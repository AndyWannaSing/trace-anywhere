package com.andy.trace;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Trace {
    private final List<Span> spans;

    public Trace() {
        this.spans = new ArrayList<>();
    }
}
