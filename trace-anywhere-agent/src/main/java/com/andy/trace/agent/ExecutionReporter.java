package com.andy.trace.agent;

import java.util.concurrent.atomic.AtomicInteger;

public class ExecutionReporter {
    private static ThreadLocal<AtomicInteger> level = new ThreadLocal<>();

    private static AtomicInteger checkCurrentLevel() {
        AtomicInteger currentLevel = level.get();
        if (currentLevel == null) {
            currentLevel = new AtomicInteger(0);
            level.set(currentLevel);
            return currentLevel;
        }
        return currentLevel;
    }

    private static int getAndIncrementCurrentLevel() {
        return checkCurrentLevel().getAndIncrement();
    }

    private static int decrementAndGetCurrentLevel() {
        return checkCurrentLevel().decrementAndGet();
    }


    public static void report(String message) {
        // 实现上报逻辑，这里只是简单打印，您可以扩展为网络请求或其他方式
        System.out.println(message);
    }

    public static void start(String className, String methodName) {
        int currentLevel = getAndIncrementCurrentLevel();
        String classMethodName = className + "#" + methodName;
        AppStartMethodAccessCounter.count(classMethodName);
        if(AppStartMethodAccessCounter.lastAccessCount(classMethodName) > 100){
            return;
        }


        // 监控方法开始

        String indent = " ".repeat(currentLevel); // 使用 String.repeat() 进行缩进
        //String methodInfo = String.format("%sEnter %s#%s", indent, className, methodName);
        String methodInfo = String.format("%s%s", indent, Thread.currentThread().getStackTrace()[3].toString());
        System.out.println(methodInfo);
        HighPerformanceFileWriter.writeAsync(methodInfo);
    }

    public static void end(String className, String methodName) {
        int currentLevel = decrementAndGetCurrentLevel();
        String classMethodName = className + "#" + methodName;
        if(AppStartMethodAccessCounter.lastAccessCount(classMethodName) > 100){
            return;
        }

        // 监控方法结束
        String indent = " ".repeat(currentLevel); // 使用 String.repeat() 进行缩进
        String methodInfo = String.format("%sExit %s#%s", indent, className, methodName);
        if(methodInfo.contains("Exit org/springframework/boot/SpringApplicationShutdownHook#run")){
            AppStartMethodAccessCounter.finishCount();
        }
        //System.out.println(methodInfo);
    }
}
