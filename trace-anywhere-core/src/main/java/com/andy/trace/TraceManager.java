package com.andy.trace;

import java.util.Stack;
import java.util.UUID;

public class TraceManager {
    private static ThreadLocal<Stack<Span>> METHOD_VISITED_SPAN_STACK = new ThreadLocal<>();

    public static void report(Span span) {
        System.out.println("上报信息");
    }

    public static void reportMethodVisited(String className, String methodName) {
        Span span = getMethodVisitedSpan();
        Log log = new Log(System.currentTimeMillis(), "执行方法", className + "." + methodName);
        span.getLogs().add(log);
        TraceContextHolder.addSpan(span);
        push2VisitedSpanStack(span);
        System.out.println("开始执行方法：" + className + "." + methodName);
    }

    private static void push2VisitedSpanStack(Span span) {
        Stack<Span> methodVisitedSpanStack = METHOD_VISITED_SPAN_STACK.get();
        if (methodVisitedSpanStack == null) {
            methodVisitedSpanStack = new Stack<>();
            METHOD_VISITED_SPAN_STACK.set(methodVisitedSpanStack);
        }
        methodVisitedSpanStack.push(span);
    }

    private static Span getMethodVisitedSpan() {
        String traceId = TraceContextHolder.getTraceId();
        Span span = new Span();
        span.setTraceId(traceId);
        span.setSpanId(UUID.randomUUID().toString());
        Span parentSpan = getParentSpan();
        if (parentSpan != null) {
            span.setParentSpanId(parentSpan.getSpanId());
        }
        span.setStartTime(System.currentTimeMillis());
        return span;
    }

    private static Span getParentSpan() {
        Stack<Span> methodVisitedSpanStack = METHOD_VISITED_SPAN_STACK.get();
        if (methodVisitedSpanStack == null) {
            methodVisitedSpanStack = new Stack<>();
            METHOD_VISITED_SPAN_STACK.set(methodVisitedSpanStack);
        }
        return methodVisitedSpanStack.isEmpty() ? null : methodVisitedSpanStack.peek();
    }

    public static void reportMethodReturn(String className, String methodName) {
        Span span = METHOD_VISITED_SPAN_STACK.get().pop();
        span.setEndTime(System.currentTimeMillis());
        System.out.println("方法执行结束：" + className + "." + methodName);
        TraceContextHolder.printTrace();
    }

    public static void reportMethodThrow(String className, String methodName) {
        Span span = METHOD_VISITED_SPAN_STACK.get().pop();
        span.setEndTime(System.currentTimeMillis());
        System.out.println("方法执行异常：" + className + "." + methodName);
        TraceContextHolder.printTrace();
    }


}
