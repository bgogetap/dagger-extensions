import com.android.build.gradle.LibraryPlugin
import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.internal.plugins.DslObject

buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

subprojects {
    group = properties["GROUP"].toString()
    version = properties["VERSION_NAME"].toString()

    plugins.withType<LibraryPlugin> {
        apply(plugin = "com.github.dcendents.android-maven")
        apply<BintrayPlugin>()

        val sourcesJarTask = tasks.create<Jar>("sourcesJar") {
            classifier = "sources"
            from(this@withType.extension.sourceSets["main"].java.srcDirs)
        }

        (tasks["install"] as Upload).run {
            DslObject(repositories).convention
                    .getPlugin<MavenRepositoryHandlerConvention>()
                    .mavenInstaller {
                        pom {
                            project {
                                packaging = "aar"
                                groupId = properties["GROUP"].toString()
                                artifactId = this@subprojects.name
                                version = properties["VERSION_NAME"].toString()
                            }
                        }
                    }
            tasks["bintrayUpload"].dependsOn(this)
        }

        artifacts {
            add("archives", sourcesJarTask)
        }

        configure<BintrayExtension> {
            user = System.getenv("BINTRAY_USER")
            key = System.getenv("BINTRAY_KEY")
            setConfigurations("archives")
            pkg = PackageConfig().apply {
                repo = "android"
                name = "dagger-extensions-scoping"
                userOrg = user
                setLicenses("Apache-2.0")
                vcsUrl = "https://github.com/bgogetap/dagger-extensions"
                version = VersionConfig().apply {
                    name = properties["VERSION_NAME"].toString()
                    desc = properties["${this@subprojects.name.toUpperCase()}_POM_DESCRIPTION"].toString()
                }
            }
        }
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}