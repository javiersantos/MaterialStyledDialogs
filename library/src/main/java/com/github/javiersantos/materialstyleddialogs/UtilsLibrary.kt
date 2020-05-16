package com.github.javiersantos.materialstyleddialogs

import android.content.Context
import android.os.Build
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

internal object UtilsLibrary {
    @JvmStatic
    fun getPrimaryColor(context: Context): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        return typedValue.data
    }

    @JvmStatic
    fun dpToPixels(context: Context, dp: Int) =
        (dp * context.resources.displayMetrics.density + 0.5f).toInt()

    @JvmStatic
    fun getColor(context: Context?, @ColorRes colorId: Int) = ContextCompat.getColor(context!!, colorId)
    fun checkApiGreaterThan(api: Int) = Build.VERSION.SDK_INT >= api
}