package com.zq.latte_core.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.zq.latte_core.app.Latte;

/**
 * Created by zhangqi on 2019/11/6
 */
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {
    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        REFRESH_LAYOUT.setRefreshing(false);
                    }
                }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
