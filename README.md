Dagger Extensions
-----------------
-----------------
A collection of libraries used to extend the utility of Dagger 2 in Android.

Scoping
_______
Allow Dagger Components to be retained for the full scope of an Activity/Fragment.

If the user is on a screen and it gets recreated due to a configuration change, as far as they are 
concerned, they are on the same screen. Most dependencies fit into that definition of a scope, 
which is where this simple tool can help.

This feature is powered by ViewModels from Android Architecture Components, which follow the same
principal of scoping. 

This will be released as a library soon, though bringing this functionality to your project will only
require a few files. For now you can look at the sample app for example usage.



Testing
_______
All modules tests will be executed by running `python3 run_tests.py`



License
-------

    Copyright 2019 Brandon Gogetap
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.