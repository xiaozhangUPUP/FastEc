package com.zq.fastec;

import android.support.multidex.MultiDexApplication;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.google.gson.Gson;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zq.latte_core.app.Latte;
import com.zq.latte_core.net.interceptors.CommonParamsInterceptor;
import com.zq.latte_core.net.interceptors.DebugInterceptor;
import com.zq.latte_ec.database.DatabaseManager;
import com.zq.latte_ec.icon.FontEcModule;

/**
 * Created by zhangqi on 2019/10/25
 */
public class ExampleAppliaction extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontEcModule())
                .withIcon(new FontAwesomeModule())
                .withLoaderDelayed(0)
                .withApiHost("http://112.124.22.238:8081/course_api/cniaoplay/")
                .withInterceptor(new DebugInterceptor("index_debug", R.raw.test))
                .withInterceptor(new CommonParamsInterceptor(this, new Gson()))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();

        DatabaseManager.getInstance().init(this);

        DoraemonKit.install(this);

    }

}
