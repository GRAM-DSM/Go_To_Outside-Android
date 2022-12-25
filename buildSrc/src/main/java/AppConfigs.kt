/**
 * @author junsuPark
 * An object class sets of app configurations.
 */
object AppConfigs {

    /**
     * An application name
     * Needs to be edited for the application.
     */
    const val applicationName = "Go To Outside"

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
     * Configuration expresses TestInstrumentationRunner.
     */
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    /**
     * An object class sets of Proguard rules.
     */
    object Proguard {
        const val defaultProguardFileName = "proguard-android-optimize.txt"
        const val proguardRules = "proguard-rules.pro"
        const val consumerRules = "consumer-rules.pro"
    }

    /**
     * An object class sets of project SDK versions declarations.
     */
    object SDK {
        const val minimumSdkVersion = 26
        const val targetSdkVersion = 33
        const val compileSdkVersion = 33
    }

    /**
     * An object class sets of Kotlin options.
     */
    object Kotlin {
        const val jvmTarget = "1.8"
    }
}