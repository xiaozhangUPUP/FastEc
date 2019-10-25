package com.zq.latte_core.app;

import java.util.HashMap;

/**
 * Created by zhangqi on 2019/10/25
 */
public class Configurator {

    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();


    public Configurator withApiHost(String url) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), url);
        return this;
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    final <T> T getConfiguration(Enum<ConfigKeys> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }


    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }


    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
}
