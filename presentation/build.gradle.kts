plugins {
    id(Dependency.Plugin.Application.application)
    id(Dependency.Plugin.Kotlin.androidKotlin)
    id(Dependency.Plugin.Kotlin.kapt)
}

android {
    namespace = AppConfig.Namespace.presentation
    compileSdk = AppConfig.SDK.compileSdkVersion

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

    with(Dependency.Local) {
        implementation(room)
        kapt(roomCompiler)
    }

    with(Dependency.DI) {
        implementation(hiltAndroid)
        kapt(hiltAndroidCompiler)
    }

    with(Dependency.Network) {
        implementation(okHttp)
        implementation(okHttpLogginIntercepter)
        implementation(retrofit)
        implementation(retrofitGsonConverter)
    }

    with(Dependency.Test) {
        testImplementation(jUnit)
        androidTestImplementation(androidJUnit)
        androidTestImplementation(espresso)
    }
}