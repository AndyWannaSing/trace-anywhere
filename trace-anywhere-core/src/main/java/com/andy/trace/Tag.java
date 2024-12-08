package com.andy.trace;

import lombok.Data;

@Data
public class Tag {
    private String key;
    private String value;

    public Tag(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Tag() {
    }
}
