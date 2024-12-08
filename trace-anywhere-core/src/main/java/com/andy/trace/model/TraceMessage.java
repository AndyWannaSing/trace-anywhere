package com.andy.trace.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 追踪消息
 */
@Data
public class TraceMessage implements Serializable {
    /**
     * 追踪ID
     */
    private String traceId;

    /**
     * 追踪时间
     */
    private Date traceTime;

    /**
     * 追踪消息内容
     */
    private String content;

    /**
     * 堆栈信息
     */
    private StackTraceElement[] stackTraceElements;
}
