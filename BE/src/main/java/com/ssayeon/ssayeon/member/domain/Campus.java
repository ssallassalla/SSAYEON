package com.ssayeon.ssayeon.member.domain;

import java.util.Arrays;

public enum Campus {
    GWANGJU("GWANGJU"), SEOUL("SEOUL"), BUSAN("BUSAN"), DAEJEON("DAEJEON"), GUMI("GUMI");

    private String name;

    Campus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNot(String campus) {
        return !this.name.equals(campus);
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException();
        }
    }

    public static Campus from(String value) {
        return Arrays.stream(values())
                .filter(campus -> campus.name.equalsIgnoreCase(value))
                .findAny()
                .orElseThrow();
    }

}
