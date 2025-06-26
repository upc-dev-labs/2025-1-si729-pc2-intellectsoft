package com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.transform;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.resources.WebApplicationResource;

public class WebApplicationResourceFromEntityAssembler {
    public static WebApplicationResource toResourceFromEntity(WebApplication entity) {
        return new WebApplicationResource(
                entity.getId(),
                entity.getName(),
                entity.getClientId().clientId(),
                entity.getFrontendStack().name(),
                entity.getFrontendUrl().webAddress(),
                entity.getBackendStack().name(),
                entity.getBackendUrl().webAddress(),
                entity.getCloudPlatform().name(),
                entity.getDescription(),
                entity.getAvailablePercentage(),
                entity.getLaunchDate()
        );
    }
}
