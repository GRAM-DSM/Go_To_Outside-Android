plugins {
    id(Dependency.Plugin.Android.library)
    id(Dependency.Plugin.Kotlin.androidKotlin)
    id(Dependency.Plugin.Kotlin.kapt)
}

android {
    namespace = AppConfig.Namespace.domain
    compileSdk = AppConfig.SDK.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.SDK.minimumSdkVersion
        targetSdk = AppConfig.SDK.targetSdkVersion
        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        consumerProguardFiles(AppConfig.Proguard.consumerRules)
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(AppConfig.Proguard.defaultProguardFileName),
                AppConfig.Proguard.proguardRules,
            )
        }
    }
    compileOptions {
        with(Version.Java.javaVersion) {
            sourceCompatibility = this
            targetCompatibility = this
        }
    }
    kotlinOptions {
        jvmTarget = AppConfig.Kotlin.jvmTarget
    }
}

dependencies {

    with(Dependency.Android) {
        implementation(core)
        implementation(appCompat)
    }

    with(Dependency.Test) {
        implementation(jUnit)
        androidTestImplementation(androidJUnit)
        androidTestImplementation(espresso)
    }
}