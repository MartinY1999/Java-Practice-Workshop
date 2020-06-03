package com.coin;

public enum Face {
    HEAD(1),
    TAIL(2);

    private final int value;
    private Face(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
