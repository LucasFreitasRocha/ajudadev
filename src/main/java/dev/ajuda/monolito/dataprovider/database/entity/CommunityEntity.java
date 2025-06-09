package dev.ajuda.monolito.dataprovider.database.entity;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "community")
public class CommunityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    public CommunityDomain toDomain() {
        return CommunityDomain.builder()
                .id(id)
                .name(name)
                .description(description)
                .city(city.toDomain())
                .owner(owner.toDomain())
                .build();
    }

    public static CommunityEntity fromDomain(CommunityDomain communityDomain) {
        return CommunityEntity.builder()
                .id(communityDomain.getId())
                .name(communityDomain.getName())
                .description(communityDomain.getDescription())
                .city(CityEntity.fromDomain(communityDomain.getCity()))
                .owner(UserEntity.fromDomain(communityDomain.getOwner()))
                .build();
    }
}
