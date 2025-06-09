package dev.ajuda.monolito.dataprovider.database.entity;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.StatesBrazil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
public class CityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Convert(converter = StatesBrazilConverter.class)
    @Column(nullable = false, name = "state")
    private StatesBrazil state;


    public City toDomain() {
        return City.builder()
                .id(id)
                .name(name)
                .state(state)
                .build();
    }
    public static CityEntity fromDomain(City city) {
        return CityEntity.builder()
                .id(city.getId())
                .name(city.getName())
                .state(city.getState())
                .build();
    }

}
