package com.zq.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.zq.latte_core.activities.ProxyActivity;
import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_ec.launcher.LauncherDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar =
                getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }
}
