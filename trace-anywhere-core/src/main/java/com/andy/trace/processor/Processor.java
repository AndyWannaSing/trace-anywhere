package com.andy.trace.processor;

import com.andy.trace.model.TraceData;

public interface Processor {
    void process(TraceData data);
}
