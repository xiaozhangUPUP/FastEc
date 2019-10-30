package com.zq.latte_ec.launcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_core.ui.launcher.ScrollLauncherTag;
import com.zq.latte_core.util.storage.LattePreference;
import com.zq.latte_ec.R;
import com.zq.latte_ec.R2;

import java.text.MessageFormat;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqi on 2019/10/29
 */
public class LauncherDelegate extends LatteDelegate {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView tvLauncherTimer;

    private Timer timer;
    private int mCount = 5;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initTimer();
    }

    private void initTimer() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (tvLauncherTimer != null) {
                                tvLauncherTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                                mCount--;
                                if (mCount < 0) {
                                    if (timer != null) {
                                        timer.cancel();
                                        timer = null;
                                        checkIsShowScroll();
                                    }
                                }
                            }
                        }
                    });
                }
            }, 0, 1000);
        }
    }

    /**
     * 判断是否显示滑动启动页
     */
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCH_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            // 检查用户是否已经登陆
        }
    }


    @OnClick(R2.id.tv_launcher_timer)
    public void onViewClicked() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            checkIsShowScroll();
        }
    }
}
