package dev.ajuda.monolito.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class City {
    private final Long id;
    private final String name;
    private final StatesBrazil state;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state=" + state.getPostalAcronym() +
                '}';
    }
}
