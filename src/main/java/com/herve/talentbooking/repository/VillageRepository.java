package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
    List<Village> findBySectorId(Long sectorId);
    List<Village> findByCellId(Long cellId);
}