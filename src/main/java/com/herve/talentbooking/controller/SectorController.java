package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.Sector;
import com.herve.talentbooking.service.SectorService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PostMapping
    public Sector createSector(@RequestBody Sector sector) {
        return sectorService.saveSector(sector);
    }

    @GetMapping
    public Page<Sector> getAllSectors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return sectorService.getAllSectors(page, size, sortBy);
        }
        return sectorService.getAllSectors(page, size);
    }

    @GetMapping("/by-district/{districtId}")
    public List<Sector> getSectorsByDistrict(@PathVariable Long districtId) {
        return sectorService.getSectorsByDistrictId(districtId);
    }

    @PutMapping("/{id}")
    public Sector updateSector(@PathVariable Long id, @RequestBody Sector sector) {
        return sectorService.updateSector(id, sector);
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable Long id) {
        sectorService.deleteSector(id);
    }
}
