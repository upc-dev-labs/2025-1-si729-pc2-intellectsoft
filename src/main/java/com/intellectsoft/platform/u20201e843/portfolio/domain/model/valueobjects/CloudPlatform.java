package com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum CloudPlatform {
    AWS(1, "AWS"),
    AZURE(2, "AZURE"),
    GCP(3, "GCP");

    private final int id;

    private final String name;

    CloudPlatform(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CloudPlatform fromName(String value) {
        value = value.toUpperCase();
        for (CloudPlatform cloudPlatform : CloudPlatform.values()) {
            if (cloudPlatform.name.equals(value)) {
                return cloudPlatform;
            }
        }
        throw new IllegalArgumentException("Invalid CloudPlatform: " + value);
    }

    public static CloudPlatform fromId(int key) {
        for (CloudPlatform cloudPlatform : CloudPlatform.values()) {
            if (cloudPlatform.getId() == key) {
                return cloudPlatform;
            }
        }
        throw new IllegalArgumentException("Invalid CloudPlatform: " + key);
    }
}
