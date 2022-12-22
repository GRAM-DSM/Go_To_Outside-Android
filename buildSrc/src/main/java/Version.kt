import org.gradle.api.JavaVersion

/**
 * @author junsuPark
 * An object class sets of dependency versions.
 */
object Version {

    /**
     * An object class sets of UI dependencies version.
     */
    object UI {
        const val constraintLayoutVersion = "2.1.4"
    }

    /**
     * An object class sets of Java dependencies version.
     */
    object Java {
        val javaVersion = JavaVersion.VERSION_1_8
    }

    /**
     * An object class sets of Gradle dependencies version.
     */
    object Gradle {
        //  const val android_version =
    }

    /**
     * An object class sets of Android dependencies version.
     */
    object Android {
        const val appcompatVersion = "1.5.1"
        const val coreVersion = "1.9.0"
    }

    /**
     * An object class sets of Material dependencies version.
     */
    object Material {
        const val materialVersion = "1.7.0"
    }

    /**
     * An object class sets of Kotlin dependencies version.
     */
    object Kotlin {
        const val kotlinVersion = "1.7.22"
        const val coroutinesVersion = "1.7.22"
    }
}