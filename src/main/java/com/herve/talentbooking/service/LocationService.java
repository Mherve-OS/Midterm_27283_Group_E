package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Location;
import com.herve.talentbooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Page<Location> getAllLocations(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return locationRepository.findAll(pageable);
    }

    public Location getLocationById(UUID id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location updateLocation(UUID id, Location location) {
        Location existing = getLocationById(id);
        if (existing != null) {
            existing.setName(location.getName());
            existing.setCode(location.getCode());
            existing.setType(location.getType());
            existing.setParent(location.getParent());
            return locationRepository.save(existing);
        }
        return null;
    }

    public void deleteLocation(UUID id) {
        locationRepository.deleteById(id);
    }

    public List<Location> getLocationsByType(String type) {
        return locationRepository.findByType(type);
    }

    public List<Location> getLocationsByParent(UUID parentId) {
        return locationRepository.findByParentId(parentId);
    }

    public List<Location> getProvinces() {
        return locationRepository.findByTypeAndParentIsNull("PROVINCE");
    }
}
