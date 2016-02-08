package com.github.javiersantos.materialstyleddialogs;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.TypedValue;

class UtilsLibrary {

    static Integer getPrimaryColor(Context context) {
        TypedValue typedValue = new TypedValue();

        TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimary });
        int color = a.getColor(0, 0);

        a.recycle();

        return color;
    }

    static Boolean checkApiGreaterThan(Integer api) {
        return Build.VERSION.SDK_INT >= api;
    }

}
