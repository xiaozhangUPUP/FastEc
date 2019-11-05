package com.zq.fastec;

import android.support.multidex.MultiDexApplication;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zq.latte_core.app.Latte;
import com.zq.latte_core.net.interceptors.DebugInterceptor;
import com.zq.latte_ec.database.DatabaseManager;

/**
 * Created by zhangqi on 2019/10/25
 */
public class ExampleAppliaction extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withLoaderDelayed(0)
                .withApiHost("http://112.124.22.238:8081/course_api/cniaoplay/")
                .withInterceptor(new DebugInterceptor("index_debug", R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();

        DatabaseManager.getInstance().init(this);

        DoraemonKit.install(this);

    }

}
