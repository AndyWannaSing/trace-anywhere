package com.andy.trace.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TraceData implements Serializable {
    private String traceId;
    private String parentTraceId;
    private Date traceTime;
    private String request;
    private String response;
    private String stacks;
}
