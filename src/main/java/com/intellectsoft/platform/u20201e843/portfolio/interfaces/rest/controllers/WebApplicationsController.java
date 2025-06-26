package com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.controllers;

import com.intellectsoft.platform.u20201e843.portfolio.domain.services.WebApplicationCommandService;
import com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.resources.CreateWebApplicationResource;
import com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.resources.WebApplicationResource;
import com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.transform.CreateWebApplicationCommandFromResourceAssembler;
import com.intellectsoft.platform.u20201e843.portfolio.interfaces.rest.transform.WebApplicationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/clients/{clientId}/web-applications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Web Applications", description = "Endpoints for web applications")
public class WebApplicationsController {
    private final WebApplicationCommandService webApplicationCommandService;

    public WebApplicationsController(WebApplicationCommandService webApplicationCommandService) {
        this.webApplicationCommandService = webApplicationCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a web application", description = "Create a web application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Web application created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Web application not found")
    })
    public ResponseEntity<WebApplicationResource> createWebApplication(
            @PathVariable Long clientId,
            @RequestBody CreateWebApplicationResource resource
    ) {
        var createWebApplicationCommand = CreateWebApplicationCommandFromResourceAssembler.toCommandFromResource(clientId, resource);
        var webApplication = webApplicationCommandService.handle(createWebApplicationCommand);
        if (webApplication.isEmpty()) return ResponseEntity.notFound().build();
        var webApplicationResource = WebApplicationResourceFromEntityAssembler.toResourceFromEntity(webApplication.get());
        return new ResponseEntity<>(webApplicationResource, HttpStatus.CREATED);
    }
}
