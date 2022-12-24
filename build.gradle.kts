buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Plugin.Gradle.android)
        classpath(Dependencies.Plugin.Gradle.kotlin)
        classpath(Dependencies.Plugin.Gradle.hilt)
    }
}
