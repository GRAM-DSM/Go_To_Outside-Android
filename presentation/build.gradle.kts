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

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
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
        implementation(project(data))
        implementation(project(domain))
    }

    with(Dependency.Android) {
        implementation(core)
        implementation(appCompat)
    }

    with(Dependency.UI) {
        implementation(constraintLayout)
        implementation(material)
        implementation(activity)
        implementation(fragment)
    }

    with(Dependency.DI) {
        implementation(hiltAndroid)
        implementation(hiltAndroidCompiler)
    }

    with(Dependency.Network) {
        implementation(okHttp)
        implementation(okHttpLogginIntercepter)
    }

    with(Dependency.Test) {
        testImplementation(jUnit)

        androidTestImplementation(androidJUnit)
        androidTestImplementation(espresso)
    }
}