package com.github.javiersantos.materialstyleddialogs;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

class UtilsLibrary {

    static Integer getPrimaryColor(Context context) {
        TypedValue typedValue = new TypedValue();

        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);

        return typedValue.data;
    }

    static Boolean checkApiGreaterThan(Integer api) {
        return Build.VERSION.SDK_INT >= api;
    }

}
