package dev.ajuda.monolito.dataprovider.database.entity;

import dev.ajuda.monolito.core.domain.TypeUser;
import dev.ajuda.monolito.core.domain.UserDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private List<TypeUser> typeUser;

    public UserDomain toDomain() {
        return UserDomain.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .typeUser(typeUser)
                .build();
    }
    public static UserEntity fromDomain(UserDomain userDomain) {
        return UserEntity.builder()
                .id(userDomain.getId())
                .name(userDomain.getName())
                .email(userDomain.getEmail())
                .password(userDomain.getPassword())
                .typeUser(userDomain.getTypeUser())
                .build();
    }
}
