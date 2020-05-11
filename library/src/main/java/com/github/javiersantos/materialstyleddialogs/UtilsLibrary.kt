package com.github.javiersantos.materialstyleddialogs

import android.content.Context
import android.os.Build
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

internal object UtilsLibrary {
    fun getPrimaryColor(context: Context): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        return typedValue.data
    }

    fun dpToPixels(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun getColor(context: Context?, @ColorRes colorId: Int): Int {
        return ContextCompat.getColor(context!!, colorId)
    }

    fun checkApiGreaterThan(api: Int): Boolean {
        return Build.VERSION.SDK_INT >= api
    }
}