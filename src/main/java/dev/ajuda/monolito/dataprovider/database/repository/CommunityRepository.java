package dev.ajuda.monolito.dataprovider.database.repository;

import dev.ajuda.monolito.dataprovider.database.entity.CommunityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {
    @Query("""
                SELECT c FROM CommunityEntity c
                WHERE (:cityId IS NULL OR c.city.id = :cityId)
            """)
    Page<CommunityEntity> findByCityOptional(@Param("cityId") Long cityId, Pageable pageable);

}
