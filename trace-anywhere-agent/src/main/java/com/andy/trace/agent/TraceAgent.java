package com.andy.trace.agent;

import com.andy.trace.plugin.Plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class TraceAgent {
    /**
     * 插件目录
     */
    private static final String PLUGIN_DIR = "D:\\projects\\trace-anywhere\\trace-anywhere-plugin\\built_plugin_jars";
    private static final String PLUGIN_DESC_FILE = "META-INF/trace-plugins";

    public static void premain(String agentArgs, Instrumentation inst) {
        List<Plugin> allPlugins = new ArrayList<>();
        // 获取Plugin目录
        File pluginDir = new File(PLUGIN_DIR);
        // 遍历Plugin目录，加载所有的Plugin
        for (File file : pluginDir.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                List<Plugin> plugins = loadPlugins(file);
                allPlugins.addAll(plugins);
            }
        }

        for (Plugin plugin : allPlugins) {
            plugin.start(inst);
        }

        // 注册关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (Plugin plugin : allPlugins) {
                    plugin.stop();
                }
            }
        });
    }

    private static List<Plugin> loadPlugins(File file) {
        List<Plugin> plugins = new ArrayList<>();
        try {
            // 创建一个新的URLClassLoader来加载插件
            URLClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
            // 读取插件描述文件
            InputStream input = loader.getResourceAsStream(PLUGIN_DESC_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String pluginClassName;
            while ((pluginClassName = reader.readLine()) != null) {
                // 加载插件类
                Class<?> pluginClass = loader.loadClass(pluginClassName);

                // 检查插件类是否实现了 Plugin 接口
                if (!Plugin.class.isAssignableFrom(pluginClass)) {
                    throw new IllegalArgumentException(pluginClassName + " does not implement Plugin interface. FilePath=" + file.getCanonicalPath());
                }

                // 获取构造函数
                Constructor<?> constructor = pluginClass.getConstructor();

                Plugin plugin = (Plugin) constructor.newInstance();
                plugins.add(plugin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return plugins;
    }
}
