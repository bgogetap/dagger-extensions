import subprocess
import os

sample_app_integration__test_command = "app:connectedDebugAndroidTest"
scoping_integration_test_command = "scoping:connectedDebugAndroidTest"
scoping_unit_test_command = "scoping:testDebugUnitTest"

results = {}
has_failure = False

def os_gradle_command():
    return "gradlew" if os.name == 'nt' else "./gradlew"

def run_command(args):
    return subprocess.run([os_gradle_command(), args])

def is_success(result):
    return "Failed" if result.returncode == 1 else "Passed"

print("Sample app integration test")
res = run_command(sample_app_integration__test_command)
results["Sample App: Integration Test"] = is_success(res)

print("Scoping integration test")
res = run_command(scoping_integration_test_command)
results["Scoping: Integration Test"] = is_success(res)

print("Scoping unit test")
res = run_command(scoping_unit_test_command)
results["Scoping: Unit Test"] = is_success(res)

output = ""
for test, result in results.items():
    if result == "Failed":
        has_failure = True
    output += "{0} - {1}\n".format(test, result)

header_message = "\n***Some tests failed***" if has_failure else "\nAll tests passed!"

print(header_message)
print(output)
