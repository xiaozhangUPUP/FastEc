package com.zq.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.zq.latte_core.activities.ProxyActivity;
import com.zq.latte_core.app.Latte;
import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_core.ui.launcher.ILauncherListener;
import com.zq.latte_core.ui.launcher.OnLauncherFinishTag;
import com.zq.latte_ec.launcher.LauncherDelegate;
import com.zq.latte_ec.sign.SignInDelegate;

public class MainActivity extends ProxyActivity implements ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar =
                getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                startWithPop(new SignInDelegate());
                break;

        }
    }
}
