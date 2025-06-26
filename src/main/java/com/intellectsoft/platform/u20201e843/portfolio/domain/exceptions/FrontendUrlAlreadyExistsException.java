package com.intellectsoft.platform.u20201e843.portfolio.domain.exceptions;

import com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects.WebAddress;

public class FrontendUrlAlreadyExistsException extends RuntimeException {
    public FrontendUrlAlreadyExistsException(WebAddress frontendUrl) {
        super(String.format("Web application with frontend url %s already exists", frontendUrl.webAddress()));
    }
}
