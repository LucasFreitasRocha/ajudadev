package dev.ajuda.monolito.dataprovider.database.repository;

import dev.ajuda.monolito.dataprovider.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
