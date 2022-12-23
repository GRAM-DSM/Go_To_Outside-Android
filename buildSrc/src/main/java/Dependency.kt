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
                "com.google.dagger:hilt-android-gradle-plugin:${Version.Hilt.hiltVersion}"
        }
    }

    /**
     * An object class sets of UI dependency paths.
     */
    object UI {
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.UI.constraintLayoutVersion}"
    }

    /**
     * An object class sets of Android dependency paths.
     */
    object Android {
        const val core = "androidx.core:core-ktx:${Version.Android.coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.Android.appcompatVersion}"
    }

    /**
     * An object class sets of Material dependency paths.
     */
    object Material {
        const val material =
            "com.google.android.material:material:${Version.Material.materialVersion}"
    }

    /**
     * An object class sets of Test dependency paths
     */
    object Test {
        const val jUnit = "junit:junit:${Version.Test.jUnitVersion}"
        const val androidJUnit = "androidx.test.ext:junit:${Version.Test.androidJUnitVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.Test.espressoVersion}"
    }
}