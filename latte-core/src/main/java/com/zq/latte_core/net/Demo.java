package com.zq.latte_core.net;

/**
 * Created by zhangqi on 2019/10/29
 */
public class Demo {

    public static final Demo instance = new Demo();

    private static class DemoHolder {
        private static final Demo INSTANCE = new Demo();
    }

    public static Demo getInstance() {
        return DemoHolder.INSTANCE;
    }

}
