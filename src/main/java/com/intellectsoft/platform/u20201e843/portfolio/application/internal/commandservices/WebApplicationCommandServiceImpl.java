package com.intellectsoft.platform.u20201e843.portfolio.application.internal.commandservices;

import com.intellectsoft.platform.u20201e843.portfolio.domain.exceptions.BackendUrlAlreadyExistsException;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.u20201e843.portfolio.domain.exceptions.FrontendUrlAlreadyExistsException;
import com.intellectsoft.platform.u20201e843.portfolio.domain.services.WebApplicationCommandService;
import com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.repositories.WebApplicationRepository;
import com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects.WebAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebApplicationCommandServiceImpl implements WebApplicationCommandService {
    private final WebApplicationRepository webApplicationRepository;

    public WebApplicationCommandServiceImpl(WebApplicationRepository webApplicationRepository) {
        this.webApplicationRepository = webApplicationRepository;
    }

    @Override
    public Optional<WebApplication> handle(CreateWebApplicationCommand command) {
        var frontendAddress = new WebAddress(command.frontendUrl());
        var backendAddress = new WebAddress(command.backendUrl());

        if (webApplicationRepository.existsByFrontendUrl(frontendAddress)) {
            throw new FrontendUrlAlreadyExistsException(frontendAddress);
        }

        if (webApplicationRepository.existsByBackendUrl(backendAddress)) {
            throw new BackendUrlAlreadyExistsException(backendAddress);
        }

        var webApplication = new WebApplication(command);

        try {
            webApplicationRepository.save(webApplication);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving web application: %s".formatted(e.getMessage()));
        }
        return Optional.of(webApplication);
    }
}
