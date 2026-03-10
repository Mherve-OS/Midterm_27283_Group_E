package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.District;
import com.herve.talentbooking.service.DistrictService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.saveDistrict(district);
    }

    @GetMapping
    public Page<District> getAllDistricts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return districtService.getAllDistricts(page, size, sortBy);
        }
        return districtService.getAllDistricts(page, size);
    }

    @GetMapping("/by-province/{provinceId}")
    public List<District> getDistrictsByProvince(@PathVariable Long provinceId) {
        return districtService.getDistrictsByProvinceId(provinceId);
    }

    @PutMapping("/{id}")
    public District updateDistrict(@PathVariable Long id, @RequestBody District district) {
        return districtService.updateDistrict(id, district);
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
    }
}
