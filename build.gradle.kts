buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.Gradle.android)
        classpath(Dependency.Gradle.kotlin)
        classpath(Dependency.Gradle.hilt)
    }
}
