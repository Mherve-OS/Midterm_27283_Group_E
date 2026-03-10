package com.herve.talentbooking.service;

import com.herve.talentbooking.model.User;
import com.herve.talentbooking.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public Page<User> getAllUsers(int page, int size, String sortBy) {
        return userRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<User> getUsersByProvinceCode(String provinceCode) {
        return userRepository.findByProvinceCode(provinceCode);
    }

    public List<User> getUsersByProvinceName(String provinceName) {
        return userRepository.findByProvinceName(provinceName);
    }

    public List<User> getUsersByDistrictId(Long districtId) {
        return userRepository.findByDistrictId(districtId);
    }

    public List<User> getUsersBySectorId(Long sectorId) {
        return userRepository.findBySectorId(sectorId);
    }

    public List<User> getUsersByCellId(Long cellId) {
        return userRepository.findByCellId(cellId);
    }

    public List<User> getUsersByVillageId(Long villageId) {
        return userRepository.findByVillageId(villageId);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setFullName(user.getFullName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setPhoneNumber(user.getPhoneNumber());
        if (user.getVillage() != null) {
            existing.setVillage(user.getVillage());
        }
        return userRepository.save(existing);
    }
}