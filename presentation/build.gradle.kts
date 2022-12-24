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

    with(AppConfig.Module) {
        implementation(
            project(
                data,
                domain,
            )
        )
    }

    with(Dependency.Android) {
        implementation(
            core,
            appCompat,
        )
    }

    with(Dependency.UI) {
        implementation(
            constraintLayout,
            material,
            activity,
            fragment,
        )
    }

    with(Dependency.DI) {
        implementation(
            hiltAndroid,
            hiltAndroidCompiler,
        )
    }

    with(Dependency.Network) {
        implementation(
            okHttp,
            okHttpLogginIntercepter,
        )
    }

    with(Dependency.Test) {
        testImplementation(
            jUnit,
            mockito,
        )
        androidTestImplementation(
            androidJUnit,
            espresso,
        )
    }
}