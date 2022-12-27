package com.gram.presentation.util

import android.content.Context
import android.content.Intent

object StartActivityUtils {

    internal fun <T> startActivity(context: Context, to: Class<T>) {
        context.startActivity(
            Intent(
                context, to,
            )
        )
    }
}