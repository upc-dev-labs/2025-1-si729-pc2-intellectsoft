package com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the unique identifier of a Client.
 * <p>
 *     The ID must be a positive, non-null value.
 * </p>
 * @param clientId the identifier of the client
 *
 * @author author
 * @since 1.0.0
 */
@Embeddable
public record ClientId(Long clientId) {

    public ClientId() {
        this(null);
    }

    public ClientId {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client Id must be a positive integer");
        }
    }
}
