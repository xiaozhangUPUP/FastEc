package com.zq.fastec;

import com.zq.latte_core.activities.ProxyActivity;
import com.zq.latte_core.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
