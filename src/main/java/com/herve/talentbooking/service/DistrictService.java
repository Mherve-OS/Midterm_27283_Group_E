package com.herve.talentbooking.service;

import com.herve.talentbooking.model.District;
import com.herve.talentbooking.repository.DistrictRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    public Page<District> getAllDistricts(int page, int size) {
        return districtRepository.findAll(PageRequest.of(page, size));
    }

    public Page<District> getAllDistricts(int page, int size, String sortBy) {
        return districtRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public List<District> getDistrictsByProvinceId(Long provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }

    public District updateDistrict(Long id, District district) {
        District existing = districtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("District not found"));
        existing.setName(district.getName());
        if (district.getProvince() != null) {
            existing.setProvince(district.getProvince());
        }
        return districtRepository.save(existing);
    }

    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }
}