package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.Village;
import com.herve.talentbooking.service.VillageService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villages")
public class VillageController {

    private final VillageService villageService;

    public VillageController(VillageService villageService) {
        this.villageService = villageService;
    }

    @PostMapping
    public Village createVillage(@RequestBody Village village) {
        return villageService.saveVillage(village);
    }

    @GetMapping
    public Page<Village> getAllVillages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return villageService.getAllVillages(page, size, sortBy);
        }
        return villageService.getAllVillages(page, size);
    }

    @GetMapping("/by-sector/{sectorId}")
    public List<Village> getVillagesBySector(@PathVariable Long sectorId) {
        return villageService.getVillagesBySectorId(sectorId);
    }

    @GetMapping("/by-cell/{cellId}")
    public List<Village> getVillagesByCell(@PathVariable Long cellId) {
        return villageService.getVillagesByCellId(cellId);
    }

    @PutMapping("/{id}")
    public Village updateVillage(@PathVariable Long id, @RequestBody Village village) {
        return villageService.updateVillage(id, village);
    }

    @DeleteMapping("/{id}")
    public void deleteVillage(@PathVariable Long id) {
        villageService.deleteVillage(id);
    }
}
