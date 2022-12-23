/**
 * @author junsuPark
 * An object class sets of dependency paths.
 */
object Dependency {

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
     * An object class sets of Gradle Plugins dependency paths.
     */
    object Gradle {
        const val android = "com.android.tools.build:gradle:${Version.Gradle.gradleVersion}"
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin.kotlinVersion}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.Hilt.hiltVersion}"
    }
}