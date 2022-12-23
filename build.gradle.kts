buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.Plugin.Gradle.android)
        classpath(Dependency.Plugin.Gradle.kotlin)
        classpath(Dependency.Plugin.Gradle.hilt)
    }
}
