package com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.converters;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.BackendStack;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BackendStackConverter implements AttributeConverter<BackendStack, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BackendStack attribute) {
        if (attribute == null) return null;
        return attribute.getId();
    }

    @Override
    public BackendStack convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return BackendStack.fromId(dbData);
    }
}
