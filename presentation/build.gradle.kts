plugins {
    id(Dependency.Plugin.Application.application)
    id(Dependency.Plugin.Kotlin.androidKotlin)
    id(Dependency.Plugin.Kotlin.kapt)
}

android {

    compileSdk = AppConfig.SDK.compileSdkVersion
    namespace = AppConfig.Namespace.presentation

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.SDK.minimumSdkVersion
        targetSdk = AppConfig.SDK.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        Version.Java.javaVersion.run {
            sourceCompatibility = this
            targetCompatibility = this
        }
    }
    kotlinOptions {
        jvmTarget = AppConfig.Kotlin.jvmTarget
    }
}

dependencies {

    implementation(project(AppConfig.Module.data, AppConfig.Module.domain))

    implementation(Dependency.Android.core)
    implementation(Dependency.Android.appCompat)
    implementation(Dependency.Material.material)
    implementation(Dependency.UI.constraintLayout)
    testImplementation(Dependency.Test.jUnit)
    androidTestImplementation(Dependency.Test.androidJUnit)
    androidTestImplementation(Dependency.Test.espresso)
}