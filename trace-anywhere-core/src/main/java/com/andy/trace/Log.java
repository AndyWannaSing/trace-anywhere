package com.andy.trace;

import lombok.Data;

@Data
public class Log {
    private long time;
    private String key;
    private String value;

    public Log(long time, String key, String value) {
        this.time = time;
        this.key = key;
        this.value = value;
    }

    public Log() {
    }
}
