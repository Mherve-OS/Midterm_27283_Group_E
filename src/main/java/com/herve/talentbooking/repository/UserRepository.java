package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    List<User> findByLocationId(UUID locationId);

    @Query("SELECT u FROM User u WHERE u.location.parent.parent.parent.parent.code = :provinceCode")
    List<User> findByProvinceCode(@Param("provinceCode") String provinceCode);

    @Query("SELECT u FROM User u WHERE u.location.parent.parent.parent.parent.name = :provinceName")
    List<User> findByProvinceName(@Param("provinceName") String provinceName);
}