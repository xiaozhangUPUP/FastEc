package com.zq.fastec.generators;

import com.zq.latte_annotations.annotations.AppRegisterGenerator;
import com.zq.latte_core.wechat.templates.AppRegisterTemplate;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.zq.fastec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
