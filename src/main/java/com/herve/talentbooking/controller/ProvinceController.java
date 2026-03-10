package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.Province;
import com.herve.talentbooking.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping
    public Province createProvince(@RequestBody Province province) {
        return provinceService.saveProvince(province);
    }

    @GetMapping
    public Page<Province> getAllProvinces(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return provinceService.getAllProvinces(page, size);
    }

    @PutMapping("/{id}")
    public Province updateProvince(@PathVariable Long id, @RequestBody Province province) {
        return provinceService.updateProvince(id, province);
    }

    @DeleteMapping("/{id}")
    public void deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
    }
}
