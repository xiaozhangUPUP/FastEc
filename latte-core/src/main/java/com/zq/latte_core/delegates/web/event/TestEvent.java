package com.zq.latte_core.delegates.web.event;

import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by zhangqi on 2019/11/12
 */
public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), params, Toast.LENGTH_SHORT).show();

        if ("test".equals(getAction())) {
            final WebView webView = getWebView(); // native调web方法必须在主线程
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall()", null);
                }
            });

        }
        return null;
    }
}
