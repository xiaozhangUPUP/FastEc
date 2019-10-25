package com.zq.latte_core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by zhangqi on 2019/10/25
 */
public class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
