package dev.ajuda.monolito.dataprovider.database.entity;

import dev.ajuda.monolito.core.domain.StatesBrazil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class StatesBrazilConverter implements AttributeConverter<StatesBrazil, String> {
    @Override
    public String convertToDatabaseColumn(StatesBrazil statesBrazil) {
        return statesBrazil.getPostalAcronym();
    }

    @Override
    public StatesBrazil convertToEntityAttribute(String s) {
        return StatesBrazil.fromPostalAcronym(s);
    }
}

