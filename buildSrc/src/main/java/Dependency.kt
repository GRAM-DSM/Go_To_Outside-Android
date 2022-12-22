/**
 * @author junsuPark
 * An object class sets of dependency paths.
 */
object Dependency {

    /**
     * An object class sets of UI dependency paths.
     */
    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.UI.constraintLayoutVersion}"
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
        const val material = "com.google.android.material:material:${Version.Material.materialVersion}"
    }
}