package com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum BackendStack {
    SPRING_BOOT(1, "SPRING_BOOT"),
    DOTNET(2, ".NET"),
    NODEJS(3, "NODEJS");

    private final int id;

    private final String name;

    BackendStack(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static BackendStack fromName(String value) {
        value = value.toUpperCase();
        for (BackendStack bs : BackendStack.values()) {
            if (bs.name.equals(value)) {
                return bs;
            }
        }
        throw new IllegalArgumentException("Invalid backend stack: " + value);
    }

    public static BackendStack fromId(int key) {
        for (BackendStack bs : BackendStack.values()) {
            if (bs.getId() == key) {
                return bs;
            }
        }
        throw new IllegalArgumentException("Invalid backend stack: " + key);
    }
}
