package com.intellectsoft.platform.u20201e843.portfolio.infrastructure.persistence.jpa.converters;

import com.intellectsoft.platform.u20201e843.portfolio.domain.model.valueobjects.FrontendStack;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FrontendStackConverter implements AttributeConverter<FrontendStack, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FrontendStack attribute) {
        if (attribute == null) return null;
        return attribute.getId();
    }

    @Override
    public FrontendStack convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return FrontendStack.fromId(dbData);
    }
}
