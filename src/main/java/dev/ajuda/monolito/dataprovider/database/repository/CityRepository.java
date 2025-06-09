package dev.ajuda.monolito.dataprovider.database.repository;

import dev.ajuda.monolito.dataprovider.database.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
