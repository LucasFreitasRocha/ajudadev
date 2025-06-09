package dev.ajuda.monolito.dataprovider.database.repository;

import dev.ajuda.monolito.dataprovider.database.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {


}
