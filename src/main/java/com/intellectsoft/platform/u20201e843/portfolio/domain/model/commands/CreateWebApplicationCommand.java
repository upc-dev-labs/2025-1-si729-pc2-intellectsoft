package com.intellectsoft.platform.u20201e843.portfolio.domain.model.commands;

import java.time.LocalDateTime;

public record CreateWebApplicationCommand(
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
    public CreateWebApplicationCommand {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");

        if (name.length() > 80)
            throw new IllegalArgumentException("Name cannot exceed 80 characters");

        if (clientId == null || clientId >= 0)
            throw new IllegalArgumentException("Client Id cannot be null or negative");

        if (frontendStack == null || frontendStack.isBlank())
            throw new IllegalArgumentException("Frontend Stack cannot be null or empty");

        if (frontendUrl == null || frontendUrl.isBlank())
            throw new IllegalArgumentException("Frontend Url cannot be null or empty");

        if (frontendUrl.length() > 512)
            throw new IllegalArgumentException("Frontend Url cannot exceed 512 characters");

        if (!frontendUrl.matches("^(http|https)://.+"))
            throw new IllegalArgumentException("Frontend URL must start with http:// or https://");

        if (backendStack == null || backendStack.isBlank())
            throw new IllegalArgumentException("Backend Stack cannot be null or empty");

        if (backendUrl == null || backendUrl.isBlank())
            throw new IllegalArgumentException("Backend Url cannot be null or empty");

        if (!backendUrl.matches("^(http|https)://.+"))
            throw new IllegalArgumentException("Backend URL must start with http:// or https://");

        if (backendStack.length() > 512)
            throw new IllegalArgumentException("Backend Stack cannot exceed 512 characters");

        if (cloudPlatform == null || cloudPlatform.isBlank())
            throw new IllegalArgumentException("Cloud Platform cannot be null or empty");

        if (description.length() > 360)
            throw new IllegalArgumentException("Description cannot exceed 360 characters");

        if (availablePercentage == null || availablePercentage < 85 || availablePercentage > 99)
            throw new IllegalArgumentException("Available percentage must be between 85 and 99");

        if (launchDate == null)
            throw new IllegalArgumentException("Launch date cannot be null");

        if (launchDate.isBefore(LocalDateTime.of(2007, 7, 15, 0, 0)))
            throw new IllegalArgumentException("Launch date cannot be earlier than July 15, 2007");

        if (launchDate.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Launch date cannot be in the future");
    }
}
