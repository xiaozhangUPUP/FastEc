package com.zq.latte_ec.launcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_ec.R;

/**
 * Created by zhangqi on 2019/10/29
 */
public class LauncherDelegate extends LatteDelegate {

//    @BindView(R.id.tv_launcher_timer)
//    AppCompatTextView tvLauncherTimer;



    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }


//    @OnClick(R.id.tv_launcher_timer)
//    public void onViewClicked() {
//    }
}
