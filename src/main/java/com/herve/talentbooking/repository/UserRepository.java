package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.village.sector.district.province.code = :provinceCode")
    List<User> findByProvinceCode(@Param("provinceCode") String provinceCode);

    @Query("SELECT u FROM User u WHERE u.village.sector.district.province.name = :provinceName")
    List<User> findByProvinceName(@Param("provinceName") String provinceName);

    @Query("SELECT u FROM User u WHERE u.village.sector.district.id = :districtId")
    List<User> findByDistrictId(@Param("districtId") Long districtId);

    @Query("SELECT u FROM User u WHERE u.village.sector.id = :sectorId")
    List<User> findBySectorId(@Param("sectorId") Long sectorId);

    @Query("SELECT u FROM User u WHERE u.village.cell.id = :cellId")
    List<User> findByCellId(@Param("cellId") Long cellId);

    List<User> findByVillageId(Long villageId);
}