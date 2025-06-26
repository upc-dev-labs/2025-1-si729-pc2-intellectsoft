package com.intellectsoft.platform.u20201e843.portfolio.domain.services;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.commands.CreateWebApplicationCommand;

import java.util.Optional;

public interface WebApplicationCommandService {
    Optional<WebApplication> handle(CreateWebApplicationCommand command);
}
