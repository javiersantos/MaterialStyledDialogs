package com.github.javiersantos.materialstyleddialogs

import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.AnimRes

internal object UtilsAnimation {
    fun startAnimation(
        context: Context?,
        image: ImageView,
        @AnimRes anim: Int
    ) {
        val animation =
            AnimationUtils.loadAnimation(context, anim)
        image.startAnimation(animation)
    }
}