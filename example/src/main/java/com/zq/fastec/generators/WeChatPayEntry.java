package com.zq.fastec.generators;

import com.zq.latte_annotations.annotations.PayEntryGenerator;
import com.zq.latte_core.wechat.templates.WXPayEntryTemplate;

@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.zq.fastec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
