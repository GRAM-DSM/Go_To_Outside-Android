/**
 * @author junsuPark
 * An object class sets of app configurations.
 */
object AppConfig {

    /**
     * An application id.
     * Needs to be edited for the application.
     */
    const val applicationId = "com.gram.gotooutside"

    /**
     * An object class sets of module declarations.
     */
    object Module {
        const val data = ":data"
        const val domain = ":domain"
        const val presentation = ":presentation"
    }

    /**
     * An object class sets of namespaces declarations.
     * Every declarations need to be edited for the project path.
     */
    object Namespace {

        /**
         * A namespace expresses presentation module.
         */
        const val presentation = "com.gram.presentation"

        /**
         * A namespace expresses domain module.
         */
        const val domain = "com.gram.domain"

        /**
         * A namespace expresses data module.
         */
        const val data = "com.gram.data"
    }

    /**
     * Configuration expresses whether minify enabled.
     */
    const val isMinifyEnabled = false

    /**
     * An object class sets of project SDK versions declarations.
     */
    object SDK {
        const val minimumSdkVersion = 26
        const val targetSdkVersion = 32
        const val compileSdkVersion = 32
    }

    /**
     * An object class sets of Kotlin options
     */
    object Kotlin {
        const val jvmTarget = "1.8"
    }
}