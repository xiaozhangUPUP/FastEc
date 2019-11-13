package com.zq.latte_ec.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.zq.latte_core.delegates.bottom.BottomItemDelegate;
import com.zq.latte_ec.R;
import com.zq.latte_ec.R2;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by zhangqi on 2019/11/12
 */
public class TestAgentWebDelegate extends BottomItemDelegate {
    @BindView(R2.id.mldz_chufanginfo_weblayout)
    LinearLayout mldzChufanginfoWeblayout;

    @Override
    public Object setLayout() {
        return R.layout.delegate_test_agent_web;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        AgentWeb mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(mldzChufanginfoWeblayout, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()// 使用默认进度条
//                .defaultProgressBarColor() // 使用默认进度条颜色
                .createAgentWeb()//
                .ready()
                .go("https://www.jd.com");

        Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(ObservableEmitter<Void> e) throws Exception {
                Log.e("ATG", "----------subscribe: ------"+ Thread.currentThread().getName() );
//                e.onComplete();
            }
        }).subscribe();

    }
}
