package com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.converters;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.CloudPlatform;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CloudPlatformConverter implements AttributeConverter<CloudPlatform, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CloudPlatform attribute) {
        if (attribute == null) return null;
        return attribute.getId();
    }

    @Override
    public CloudPlatform convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return CloudPlatform.fromId(dbData);
    }
}
