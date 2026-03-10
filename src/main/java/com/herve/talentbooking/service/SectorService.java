package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Sector;
import com.herve.talentbooking.repository.SectorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public Sector saveSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Page<Sector> getAllSectors(int page, int size) {
        return sectorRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Sector> getAllSectors(int page, int size, String sortBy) {
        return sectorRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public List<Sector> getSectorsByDistrictId(Long districtId) {
        return sectorRepository.findByDistrictId(districtId);
    }

    public Sector updateSector(Long id, Sector sector) {
        Sector existing = sectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sector not found"));
        existing.setName(sector.getName());
        if (sector.getDistrict() != null) {
            existing.setDistrict(sector.getDistrict());
        }
        return sectorRepository.save(existing);
    }

    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }
}
