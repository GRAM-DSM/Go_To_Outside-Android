plugins {
    id(Dependency.Plugin.Android.library)
    id(Dependency.Plugin.Kotlin.androidKotlin)
    id(Dependency.Plugin.Kotlin.kapt)
}

android {
    namespace = AppConfig.Namespace.presentation
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
            project(domain),
        )
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