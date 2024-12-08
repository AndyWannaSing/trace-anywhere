package com.andy.trace.plugin;

import java.lang.instrument.Instrumentation;

public interface Plugin {
    /**
     * 当追踪工具启动时，start方法会被调用。
     * 在这个方法中，插件可以执行一些初始化操作，比如注册ClassFileTransformer来修改字节码，启动后台线程来处理收集到的数据等。
     * 这个方法是插件开始工作的入口点。
     */
    void start(Instrumentation inst);

    /**
     * 追踪工具停止时，stop方法会被调用。
     * 在这个方法中，插件可以执行一些清理操作，比如注销ClassFileTransformer，停止后台线程，释放资源等。
     * 这个方法是插件结束工作的出口点。
     */
    void stop();
}
