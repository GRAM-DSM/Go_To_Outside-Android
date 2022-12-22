plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = AppConfig.Namespace.presentation
    compileSdk = AppConfig.SDK.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.SDK.minimumSdkVersion
        targetSdk = AppConfig.SDK.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = Version.Java.javaVersion
        targetCompatibility = Version.Java.javaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}