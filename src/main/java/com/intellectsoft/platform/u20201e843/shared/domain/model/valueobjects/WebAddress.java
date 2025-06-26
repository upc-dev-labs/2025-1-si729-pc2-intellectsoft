package com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing a valid web address
 * used in frontend or backend URLs of web applications.
 *
 * <p>
 *     The address must not be null, must begin with http/https,
 *     and have a maximum length of 512 characters.
 * </p>
 * @param webAddress the actual web address string
 *
 * @author author
 * @since 1.0.0
 */
@Embeddable
public record WebAddress(String webAddress) {

    public WebAddress() {
        this(null);
    }

    public WebAddress {
        if (webAddress == null || webAddress.isBlank())
            throw new IllegalArgumentException("Web address cannot be null or empty");

        if (webAddress.length() > 512)
            throw new IllegalArgumentException("Web address cannot be longer than 512 characters");

        if (webAddress.matches("^(http|https)://.+"))
            throw new IllegalArgumentException("Web address must start with http:// or https://");
    }
}
