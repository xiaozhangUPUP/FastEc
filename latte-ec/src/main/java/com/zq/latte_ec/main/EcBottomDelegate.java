package com.zq.latte_ec.main;

import android.graphics.Color;

import com.zq.latte_core.delegates.bottom.BaseBottomDelegate;
import com.zq.latte_core.delegates.bottom.BottomItemDelegate;
import com.zq.latte_core.delegates.bottom.BottomTabBean;
import com.zq.latte_core.delegates.bottom.ItemBuilder;
import com.zq.latte_ec.main.discover.DiscoverDelegate;
import com.zq.latte_ec.main.index.IndexDelegate;

import java.util.LinkedHashMap;


public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new TestAgentWebDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
