package com.zq.fastec;

import android.app.Application;

import com.zq.latte_core.app.Latte;

/**
 * Created by zhangqi on 2019/10/25
 */
public class ExampleAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("")
                .configure();
    }
}
