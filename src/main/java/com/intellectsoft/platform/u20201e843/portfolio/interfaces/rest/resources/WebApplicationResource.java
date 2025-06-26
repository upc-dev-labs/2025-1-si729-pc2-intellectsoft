package com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.resources;

import java.time.LocalDateTime;

public record WebApplicationResource(
        Long id,
        String name,
        Long clientId,
        String frontendStack,
        String frontendUrl,
        String backendStack,
        String backendUrl,
        String cloudPlatform,
        String description,
        Integer availablePercentage,
        LocalDateTime launchDate
) {
}
