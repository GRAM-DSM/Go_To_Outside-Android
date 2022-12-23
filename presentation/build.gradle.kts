plugins {
    id(Plugin.Application.application)
    id(Plugin.Kotlin.androidKotlin)
    id(Plugin.Kotlin.kapt)
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

    implementation(project(Module.data, Module.domain))

    implementation(Dependency.Android.core)
    implementation(Dependency.Android.appCompat)
    implementation(Dependency.Material.material)
    implementation(Dependency.UI.constraintLayout)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}