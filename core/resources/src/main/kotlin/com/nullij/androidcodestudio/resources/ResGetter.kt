package com.nullij.androidcodestudio.resources

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource

/**
 * Simple accessor for Compose string resources.
 *
 * Usage:
 *   ResGetter.get(R.string.someStr)
 *   ResGetter.get(R.string.someStrWithArgs, "value")
 *   @author nullij @ https://github.com/nullij
 */
object ResGetter {

    @Composable
    @ReadOnlyComposable
    fun get(@StringRes resId: Int): String {
        return stringResource(id = resId)
    }

    @Composable
    @ReadOnlyComposable
    fun get(@StringRes resId: Int, vararg formatArgs: Any): String {
        return stringResource(id = resId, formatArgs = formatArgs)
    }
}
