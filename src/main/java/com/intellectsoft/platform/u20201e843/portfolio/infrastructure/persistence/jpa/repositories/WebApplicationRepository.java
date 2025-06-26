package com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.u20201e843.shared.domain.model.valueobjects.WebAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebApplicationRepository extends JpaRepository<WebApplication, Long> {
    boolean existsByFrontendUrl(WebAddress frontendUrl);

    boolean existsByBackendUrl(WebAddress backendUrl);
}
