package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.TalentProfile;
import com.herve.talentbooking.service.TalentProfileService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talent-profiles")
public class TalentProfileController {

    private final TalentProfileService talentProfileService;

    public TalentProfileController(TalentProfileService talentProfileService) {
        this.talentProfileService = talentProfileService;
    }

    @PostMapping
    public TalentProfile createTalentProfile(@RequestBody TalentProfile profile) {
        return talentProfileService.saveTalentProfile(profile);
    }

    @GetMapping
    public List<TalentProfile> getAllTalentProfiles(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        // Return all talent profiles if no pagination params provided
        return talentProfileService.getAllTalentProfiles();
    }

    @GetMapping("/{id}")
    public TalentProfile getTalentProfileById(@PathVariable Long id) {
        return talentProfileService.getTalentProfileById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTalentProfile(@PathVariable Long id) {
        talentProfileService.deleteTalentProfile(id);
    }

    @PutMapping("/{id}")
    public TalentProfile updateTalentProfile(@PathVariable Long id, @RequestBody TalentProfile profile) {
        return talentProfileService.updateTalentProfile(id, profile);
    }
}
