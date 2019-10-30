package com.zq.latte_ec.launcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_core.ui.launcher.LauncherHolderCreator;
import com.zq.latte_core.ui.launcher.ScrollLauncherTag;
import com.zq.latte_core.util.storage.LattePreference;
import com.zq.latte_ec.R;

import java.util.ArrayList;

/**
 * Created by zhangqi on 2019/10/30
 */
public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {
    private ConvenientBanner<Integer> mConvenientBanner = null;
    private ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCH_APP.name(), true);
            // 检查用户是否已经登陆
        }
    }
}
