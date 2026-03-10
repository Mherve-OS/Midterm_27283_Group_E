package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Province;
import com.herve.talentbooking.repository.ProvinceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public Province saveProvince(Province province) {
        return provinceRepository.save(province);
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Page<Province> getAllProvinces(int page, int size) {
        return provinceRepository.findAll(PageRequest.of(page, size));
    }

    public Province updateProvince(Long id, Province province) {
        Province existing = provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found"));
        existing.setCode(province.getCode());
        existing.setName(province.getName());
        return provinceRepository.save(existing);
    }

    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }
}