package com.herve.talentbooking.repository;

import com.herve.talentbooking.model.TalentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentProfileRepository extends JpaRepository<TalentProfile, Long> {

}