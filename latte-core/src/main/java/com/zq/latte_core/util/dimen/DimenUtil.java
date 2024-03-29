package com.zq.latte_core.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.zq.latte_core.app.Latte;


public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
