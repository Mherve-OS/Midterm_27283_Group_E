package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    List<Location> findByType(String type);
    List<Location> findByParentId(UUID parentId);
    List<Location> findByParentIdAndType(UUID parentId, String type);
    List<Location> findByTypeAndParentIsNull(String type);
}
