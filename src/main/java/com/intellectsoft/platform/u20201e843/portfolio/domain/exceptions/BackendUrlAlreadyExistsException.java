package com.intellectsoft.platform.u20201e843.portfolio.domain.exceptions;

import com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects.WebAddress;

public class BackendUrlAlreadyExistsException extends RuntimeException {
    public BackendUrlAlreadyExistsException(WebAddress backendUrl) {
        super(String.format("Web application with backend url %s already exists", backendUrl.webAddress()));
    }
}
