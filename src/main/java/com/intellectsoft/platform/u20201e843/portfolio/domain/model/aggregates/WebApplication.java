package com.intellectsoft.platform.u20201e843.portfolio.domain.model.aggregates;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.BackendStack;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.ClientId;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.CloudPlatform;
import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.FrontendStack;
import com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.converters.FrontendStackConverter;
import com.intellectsoft.platform.u20201e843.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects.WebAddress;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class WebApplication extends AuditableAbstractAggregateRoot<WebApplication> {

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false)
    private String name;

    @Embedded
    @NotNull
    @AttributeOverride(name = "clientId", column = @Column(nullable = false))
    private ClientId clientId;

    @NotNull
    @Convert(converter = FrontendStackConverter.class)
    @Column(nullable = false)
    private FrontendStack frontendStack;

    @Embedded
    @NotNull
    @AttributeOverride(name = "webAddress", column = @Column(name = "frontend_url", nullable = false))
    private WebAddress frontendUrl;

    @NotNull
    @Column(nullable = false)
    private BackendStack backendStack;

    @Embedded
    @NotNull
    @AttributeOverride(name = "webAddress", column = @Column(name = "backend_url", nullable = false))
    private WebAddress backendUrl;

    @NotNull
    @Column(nullable = false)
    private CloudPlatform cloudPlatform;

    @Size(max = 360)
    private String description;

    @NotNull
    @Min(85)
    @Max(99)
    @Column(nullable = false)
    private Integer availablePercentage;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime launchDate;

    public WebApplication() {

    }

    public WebApplication(CreateWebApplicationCommand command) {
        this.name = command.name();
        this.clientId = new ClientId(command.clientId());
        this.frontendStack = FrontendStack.fromName(command.frontendStack());
        this.frontendUrl = new WebAddress(command.frontendUrl());
        this.backendStack = BackendStack.fromName(command.backendStack());
        this.backendUrl = new WebAddress(command.backendUrl());
        this.cloudPlatform = CloudPlatform.fromName(command.cloudPlatform());
        this.description = command.description();
        this.availablePercentage = command.availablePercentage();
        this.launchDate = command.launchDate();
    }
}
