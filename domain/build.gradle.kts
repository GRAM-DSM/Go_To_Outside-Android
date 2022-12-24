plugins {
    id(Dependencies.Plugin.Android.library)
    id(Dependencies.Plugin.Kotlin.androidKotlin)
    id(Dependencies.Plugin.Kotlin.kapt)
}

android {
    namespace = AppConfigs.Namespace.domain
    compileSdk = AppConfigs.SDK.compileSdkVersion

    defaultConfig {
        minSdk = AppConfigs.SDK.minimumSdkVersion
        targetSdk = AppConfigs.SDK.targetSdkVersion
        testInstrumentationRunner = AppConfigs.testInstrumentationRunner
        consumerProguardFiles(AppConfigs.Proguard.consumerRules)
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
        with(Versions.Java.javaVersion) {
            sourceCompatibility = this
            targetCompatibility = this
        }
    }
    kotlinOptions {
        jvmTarget = AppConfigs.Kotlin.jvmTarget
    }
}

dependencies {

    with(Dependencies.Android) {
        implementation(core)
        implementation(appCompat)
    }

    with(Dependencies.Test) {
        implementation(jUnit)
        androidTestImplementation(androidJUnit)
        androidTestImplementation(espresso)
    }
}