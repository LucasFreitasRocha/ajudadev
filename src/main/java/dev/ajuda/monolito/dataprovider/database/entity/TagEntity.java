package dev.ajuda.monolito.dataprovider.database.entity;

import dev.ajuda.monolito.core.domain.TagStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Getter
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(nullable = false, unique = true)
    private final String name;

    @Setter
    @Enumerated(EnumType.STRING)
    private TagStatus status;
}
