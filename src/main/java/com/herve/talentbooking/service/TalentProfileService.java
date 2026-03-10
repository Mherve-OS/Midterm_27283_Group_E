package com.herve.talentbooking.service;

import com.herve.talentbooking.model.TalentProfile;
import com.herve.talentbooking.repository.TalentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentProfileService {

    private final TalentProfileRepository talentProfileRepository;

    public TalentProfileService(TalentProfileRepository talentProfileRepository) {
        this.talentProfileRepository = talentProfileRepository;
    }

    public TalentProfile saveTalentProfile(TalentProfile profile) {
        return talentProfileRepository.save(profile);
    }

    public List<TalentProfile> getAllTalentProfiles() {
        return talentProfileRepository.findAll();
    }

    public TalentProfile getTalentProfileById(Long id) {
        return talentProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talent profile not found"));
    }

    public void deleteTalentProfile(Long id) {
        talentProfileRepository.deleteById(id);
    }

    public TalentProfile updateTalentProfile(Long id, TalentProfile profile) {
        TalentProfile existing = talentProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talent profile not found"));
        existing.setStageName(profile.getStageName());
        existing.setCategory(profile.getCategory());
        existing.setDescription(profile.getDescription());
        existing.setPricePerEvent(profile.getPricePerEvent());
        if (profile.getUser() != null) {
            existing.setUser(profile.getUser());
        }
        return talentProfileRepository.save(existing);
    }
}