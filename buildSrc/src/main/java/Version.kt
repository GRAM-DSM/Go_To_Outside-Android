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
        const val materialVersion = "1.7.0"
        const val activityVersion = "1.6.1"
        const val fragmentVersion = "1.5.5"
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
     * An object class sets of Kotlin dependency versions.
     */
    object Kotlin {
        const val kotlinVersion = "1.7.22"
        const val coroutinesVersion = "1.6.4"
    }

    /**
     * An object class sets of Dependency Injection Library dependency versions.
     */
    object DI {
        const val hiltAndroid = "2.44.2"
        const val hiltCompiler = "2.44.2"
    }

    /**
     * An object class sets of JUnit dependency versions.
     */
    object Test {
        const val jUnitVersion = "4.13.2"
        const val androidJUnitVersion = "1.1.4"
        const val espressoVersion = "3.5.0"
    }

    /**
     * An object class sets of Network dependency versions.
     */
    object Network {
        const val retrofitVersion = "2.9.0"
        const val okHttpVersion = "4.10.0"
        const val socketIoVersion = "2.1.0"
    }

    /**
     * An object class sets of Local Database dependency versions.
     */
    object Local {
        const val roomVersion = "2.4.3"
    }
}