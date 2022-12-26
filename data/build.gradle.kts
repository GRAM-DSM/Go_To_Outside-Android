plugins {
    id(Dependencies.Plugin.Android.library)
    id(Dependencies.Plugin.Kotlin.androidKotlin)
    id(Dependencies.Plugin.Kotlin.kapt)
    id(Dependencies.Plugin.DI.hilt)
}

android {
    namespace = AppConfigs.Namespace.presentation
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
        Versions.Java.javaVersion.run {
            sourceCompatibility = this
            targetCompatibility = this
        }
    }
    kotlinOptions {
        jvmTarget = AppConfigs.Kotlin.jvmTarget
    }
}

dependencies {

    with(AppConfigs.Module) {
        implementation(
            project(domain),
        )
    }

    with(Dependencies.DI) {
        implementation(hiltAndroid)
        kapt(hiltAndroidCompiler)
        implementation(javaInject)
    }

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