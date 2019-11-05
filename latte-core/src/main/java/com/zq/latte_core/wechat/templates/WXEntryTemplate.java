package com.zq.latte_core.wechat.templates;


import com.zq.latte_core.wechat.BaseWXEntryActivity;
import com.zq.latte_core.wechat.LatteWeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
