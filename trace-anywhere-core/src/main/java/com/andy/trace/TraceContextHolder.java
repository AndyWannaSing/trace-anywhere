package com.andy.trace;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TraceContextHolder {
    private static ThreadLocal<String> TRACE_ID = new ThreadLocal<>();
    private static ThreadLocal<Trace> TRACE = new ThreadLocal<>();
    private static ThreadLocal<Map<String, List<Span>>> CHILD_SPAN_MAP = new ThreadLocal<>();
    private static ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT = new ThreadLocal<>();

    public static String getTraceId() {
        String traceId = TRACE_ID.get();
        if (traceId == null) {
            traceId = generateTraceId();
            TRACE_ID.set(traceId);
        }
        return traceId;
    }

    private static String generateTraceId() {
        SimpleDateFormat simpleDateFormat = SIMPLE_DATE_FORMAT.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            SIMPLE_DATE_FORMAT.set(simpleDateFormat);
        }
        return simpleDateFormat.format(new Date()) + UUID.randomUUID().toString().substring(0, 12);
    }

    public static void addSpan(Span span) {
        add2Trace(span);
        add2ChildSpanMap(span);
    }

    private static void add2Trace(Span span) {
        Trace trace = TRACE.get();
        if (trace == null) {
            trace = new Trace();
            TRACE.set(trace);
        }
        trace.getSpans().add(span);
    }

    private static void add2ChildSpanMap(Span span) {
        String parentSpanId = span.getParentSpanId();
        if (parentSpanId != null) {
            Map<String, List<Span>> childSpanMap = CHILD_SPAN_MAP.get();
            if (childSpanMap == null) {
                childSpanMap = new HashMap<>();
                CHILD_SPAN_MAP.set(childSpanMap);
            }
            List<Span> childSpans = childSpanMap.get(parentSpanId);
            if (childSpans == null) {
                childSpans = new ArrayList<>();
            }
            childSpans.add(span);
            childSpanMap.put(parentSpanId, childSpans);
        }
    }

    public static void printTrace() {
        System.out.println("##########################################################################################");
        Span rootSpan = TRACE.get().getSpans().get(0);
        printSpan(rootSpan, 0);
    }

    private static void printSpan(Span rootSpan, int level) {
        String whiteSpaceStr = new String(" ").repeat(level);
        System.out.println(whiteSpaceStr + rootSpan.getLogs().get(0).getKey() + rootSpan.getLogs().get(0).getValue());
        Map<String, List<Span>> childSpanMap = CHILD_SPAN_MAP.get();
        String rootSpanId = rootSpan.getSpanId();
        if (childSpanMap.containsKey(rootSpanId)) {
            List<Span> childSpans = childSpanMap.get(rootSpanId);
            childSpans.forEach(childSpan -> printSpan(childSpan, level + 1));
        }
    }
}
