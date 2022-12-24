/**
 * @author junsuPark
 * An object class sets of dependency paths.
 */
object Dependency {

    /**
     * An object class sets of plugin versions.
     */
    object Plugin {

        /**
         * An object class sets of application plugins.
         */
        object Application {
            const val application = "com.android.application"
        }

        /**
         * An object class sets of application plugins.
         */
        object Android {
            const val library = "com.android.library"
        }

        /**
         * An object class sets of kotlin plugins.
         */
        object Kotlin {
            const val androidKotlin = "kotlin-android"
            const val kapt = "kotlin-kapt"
        }

        /**
         * An object class sets of Gradle Plugins dependency paths.
         */
        object Gradle {
            const val android = "com.android.tools.build:gradle:${Version.Gradle.gradleVersion}"
            const val kotlin =
                "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin.kotlinVersion}"
            const val hilt =
                "com.google.dagger:hilt-android-gradle-plugin:${Version.DI.hiltAndroid}"
        }
    }

    /**
     * An object class sets of UI dependency paths.
     */
    object UI {
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.UI.constraintLayoutVersion}"
        const val material =
            "com.google.android.material:material:${Version.UI.materialVersion}"
        const val activity =
            "androidx.activity:activity-ktx:${Version.UI.activityVersion}"
        const val fragment =
            "androidx.fragment:fragment-ktx:${Version.UI.fragmentVersion}"
    }

    /**
     * An object class sets of Android dependency paths.
     */
    object Android {
        const val core = "androidx.core:core-ktx:${Version.Android.coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.Android.appcompatVersion}"
    }

    /**
     * An object class sets of Test dependency paths.
     */
    object Test {
        const val jUnit = "junit:junit:${Version.Test.jUnitVersion}"
        const val androidJUnit = "androidx.test.ext:junit:${Version.Test.androidJUnitVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.Test.espressoVersion}"
    }

    /**
     * An object class sets of Dependency Injection dependency paths.
     */
    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.DI.hiltAndroid}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Version.DI.hiltAndroid}"
    }

    /**
     * An object class sets of Network dependency paths.
     */
    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Network.retrofitVersion}"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:retrofit:${Version.Network.retrofitVersion}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Version.Network.okHttpVersion}"
        const val okHttpLogginIntercepter =
            "com.squareup.okhttp3:logging-interceptor:${Version.Network.okHttpVersion}"
        const val socketIO = "io.socket:socket.io-client:${Version.Network.socketIoVersion}"
    }

    /**
     * An object class sets of Local Database dependency paths.
     */
    object Local {
        const val room = "androidx.room:room-ktx:${Version.Local.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Version.Local.roomVersion}"
    }
}