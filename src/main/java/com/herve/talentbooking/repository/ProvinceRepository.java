package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Optional<Province> findByCode(String code);
    Optional<Province> findByName(String name);
}