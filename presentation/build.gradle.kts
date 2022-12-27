plugins {
    id(Dependencies.Plugin.Application.application)
    id(Dependencies.Plugin.Kotlin.androidKotlin)
    id(Dependencies.Plugin.DI.hilt)
    id(Dependencies.Plugin.Kotlin.kapt)
}

android {
    namespace = AppConfigs.Namespace.presentation
    compileSdk = AppConfigs.SDK.compileSdkVersion

    defaultConfig {
        applicationId = AppConfigs.applicationId
        minSdk = AppConfigs.SDK.minimumSdkVersion
        targetSdk = AppConfigs.SDK.targetSdkVersion
        testInstrumentationRunner = AppConfigs.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfigs.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(AppConfigs.Proguard.defaultProguardFileName),
                AppConfigs.Proguard.proguardRules,
            )
        }
    }
    compileOptions {
        Versions.Java.javaVersion.run {
            sourceCompatibility = this
            targetCompatibility = this
        }
    }
    kotlinOptions {
        jvmTarget = AppConfigs.Kotlin.jvmTarget
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    with(AppConfigs.Module) {
        implementation(project(data))
        implementation(project(domain))
    }

    with(Dependencies.Android) {
        implementation(core)
        implementation(appCompat)
    }

    with(Dependencies.UI) {
        implementation(constraintLayout)
        implementation(material)
        implementation(activity)
        implementation(fragment)
    }

    with(Dependencies.Local) {
        implementation(room)
        kapt(roomCompiler)
    }

    with(Dependencies.DI) {
        implementation(hiltAndroid)
        kapt(hiltAndroidCompiler)
    }

    kapt("androidx.databinding:databinding-compiler:7.3.1")

    with(Dependencies.Network) {
        implementation(okHttp)
        implementation(okHttpLogginIntercepter)
        implementation(retrofit)
        implementation(retrofitGsonConverter)
    }

    with(Dependencies.Test) {
        testImplementation(jUnit)
        androidTestImplementation(androidJUnit)
        androidTestImplementation(espresso)
    }
}

kapt {
    correctErrorTypes = true
}