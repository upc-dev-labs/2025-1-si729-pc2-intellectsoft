package com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects;

import lombok.Getter;

/**
 * Enumeration representing the available frontend technology stacks
 * supported by IntellectSoft for web applications.
 *
 * <p>
 *     Each value corresponds to a specific frontend framework used
 *     during the development of the web application.
 * </p>
 *
 * @author author
 * @since 1.0.0
 */
@Getter
public enum FrontendStack {
    ANGULAR(1, "ANGULAR"),
    VUE(2, "VUE"),
    REACT(3, "REACT");

    private final int id;

    private final String name;

    FrontendStack(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static FrontendStack fromName(String value) {
        value = value.toUpperCase();
        for (FrontendStack fs : FrontendStack.values()) {
            if (fs.name.equals(value)) {
                return fs;
            }
        }
        throw new IllegalArgumentException("Invalid frontend stack: " + value);
    }

    public static FrontendStack fromId(int key) {
        for (FrontendStack fs : FrontendStack.values()) {
            if (fs.getId() == key) {
                return fs;
            }
        }
        throw new IllegalArgumentException("Invalid frontend stack: " + key);
    }
}
