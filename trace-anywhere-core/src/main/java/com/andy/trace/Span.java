package com.andy.trace;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Span {
    @Setter
    private String traceId;
    @Setter
    private String spanId;
    @Setter
    private String parentSpanId;
    @Setter
    private long startTime;
    @Setter
    private long endTime;
    @Setter
    private String serviceInstanceName;
    private final List<Tag> tags;
    private final List<Log> logs;

    public Span() {
        this.tags = new ArrayList<>();
        this.logs = new ArrayList<>();
    }
}
