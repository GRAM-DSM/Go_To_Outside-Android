package com.gram.presentation.util

import android.app.Activity
import android.content.Intent

internal fun <T> startActivity(
    activityContext: Activity, to: Class<T>,
) {
    activityContext.run {
        startActivity(
            Intent(
                activityContext, to,
            ),
        )
    }
}

internal fun <T> startActivityFinishingCurrentActivity(
    activityContext: Activity, to: Class<T>,
) {
    startActivity(
        activityContext, to,
    )
    activityContext.finish()
}

internal fun <T> startActivityInvokingFunction(
    activityContext: Activity, to: Class<T>, block: () -> Any?
) {
    block()
    startActivity(
        activityContext, to,
    )
}

internal fun <T> startActivityFinishingCurrentActivityInvokingFunction(
    activityContext: Activity, to: Class<T>, block: () -> Unit
) {
    block()
    startActivityFinishingCurrentActivity(
        activityContext, to,
    )
}