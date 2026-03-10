package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Village;
import com.herve.talentbooking.repository.VillageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService {

    private final VillageRepository villageRepository;

    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }

    public Village saveVillage(Village village) {
        return villageRepository.save(village);
    }

    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }

    public Page<Village> getAllVillages(int page, int size) {
        return villageRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Village> getAllVillages(int page, int size, String sortBy) {
        return villageRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public List<Village> getVillagesBySectorId(Long sectorId) {
        return villageRepository.findBySectorId(sectorId);
    }

    public List<Village> getVillagesByCellId(Long cellId) {
        return villageRepository.findByCellId(cellId);
    }

    public Village updateVillage(Long id, Village village) {
        Village existing = villageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Village not found"));
        existing.setName(village.getName());
        if (village.getSector() != null) {
            existing.setSector(village.getSector());
        }
        return villageRepository.save(existing);
    }

    public void deleteVillage(Long id) {
        villageRepository.deleteById(id);
    }
}
