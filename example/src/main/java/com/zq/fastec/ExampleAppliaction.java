package com.zq.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zq.latte_core.app.Latte;

/**
 * Created by zhangqi on 2019/10/25
 */
public class ExampleAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .configure();

    }
}
