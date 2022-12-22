/**
 * @author junsuPark
 * An object class sets of dependency paths.
 */
object Dependency {

    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.UI.constraintLayoutVersion}"
    }

    object Android {
        const val core = "androidx.core:core-ktx:${Version.Android.coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.Android.appcompatVersion}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Version.Material.materialVersion}"
    }
}