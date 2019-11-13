package com.zq.fastec;

import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDexApplication;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.google.gson.Gson;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zq.latte_core.app.Latte;
import com.zq.latte_core.delegates.web.event.TestEvent;
import com.zq.latte_core.net.interceptors.CommonParamsInterceptor;
import com.zq.latte_core.net.interceptors.DebugInterceptor;
import com.zq.latte_ec.database.DaoMaster;
import com.zq.latte_ec.database.DaoSession;
import com.zq.latte_ec.database.DatabaseManager;
import com.zq.latte_ec.icon.FontEcModule;

/**
 * Created by zhangqi on 2019/10/25
 */
public class ExampleAppliaction extends MultiDexApplication {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static ExampleAppliaction INSTANCE;

    public static ExampleAppliaction getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Latte.init(this)
                .withIcon(new FontEcModule())
                .withIcon(new FontAwesomeModule())
                .withLoaderDelayed(0)
                .withApiHost("http://112.124.22.238:8081/course_api/cniaoplay/")
                .withInterceptor(new DebugInterceptor("index_debug", R.raw.test))
                .withInterceptor(new CommonParamsInterceptor(this, new Gson()))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .withWebEvent("test", new TestEvent())
                .configure();

        DatabaseManager.getInstance().init(this);

        DoraemonKit.install(this);
//        setDatabase();
    }

    /**
     * 设置greenDAO
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
}



