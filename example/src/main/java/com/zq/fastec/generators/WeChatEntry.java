package com.zq.fastec.generators;


import com.zq.latte_annotations.annotations.EntryGenerator;
import com.zq.latte_core.wechat.templates.WXEntryTemplate;

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.zq.fastec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
