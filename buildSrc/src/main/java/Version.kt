import org.gradle.api.JavaVersion

/**
 * @author junsuPark
 * An object class sets of dependency versions.
 */
object Version {

    /**
     * An object class sets of UI dependency versions.
     */
    object UI {
        const val constraintLayoutVersion = "2.1.4"
    }

    /**
     * An object class sets of Java dependency versions.
     */
    object Java {
        val javaVersion = JavaVersion.VERSION_1_8
    }

    /**
     * An object class sets of Gradle dependency versions.
     */
    object Gradle {
        const val gradleVersion = "7.3.1"
    }

    /**
     * An object class sets of Android dependency versions.
     */
    object Android {
        const val application = "7.3.1"
        const val appcompatVersion = "1.5.1"
        const val coreVersion = "1.9.0"
    }

    /**
     * An object class sets of Material dependency versions.
     */
    object Material {
        const val materialVersion = "1.7.0"
    }

    /**
     * An object class sets of Kotlin dependency versions.
     */
    object Kotlin {
        const val kotlinVersion = "1.7.22"
        const val coroutinesVersion = "1.6.4"
    }

    /**
     * An object class sets of Hilt dependency versions.
     */
    object Hilt {
        const val hiltVersion = "2.44.2"
    }

    /**
     * An object class sets of JUnit dependency versions.
     */
    object Test {
        const val jUnitVersion = "4.13.2"
        const val androidJUnitVersion = "1.1.4"
        const val espressoVersion = "3.5.0"
    }
}