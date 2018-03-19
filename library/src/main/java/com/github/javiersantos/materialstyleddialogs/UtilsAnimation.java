package com.github.javiersantos.materialstyleddialogs;

import android.content.Context;
import android.support.annotation.AnimRes;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class UtilsAnimation {

    static void startAnimation(Context context, ImageView image, @AnimRes int anim){
        Animation animation = AnimationUtils.loadAnimation(context,anim);
        image.startAnimation(animation);
    }
}
