package com.github.javiersantos.materialstyleddialogs

import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.AnimRes

internal object UtilsAnimation {
    @JvmStatic
    fun startAnimation(context: Context?, image: ImageView, @AnimRes anim: Int) =
        image.startAnimation(AnimationUtils.loadAnimation(context, anim))
}