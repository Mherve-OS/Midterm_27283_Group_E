package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.User;
import com.herve.talentbooking.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public Page<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return userService.getAllUsers(page, size, sortBy);
        }
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/check-email")
    public boolean checkEmailExists(@RequestParam String email) {
        return userService.checkEmailExists(email);
    }

    @GetMapping("/by-province")
    public List<User> getUsersByProvince(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name
    ) {
        if (code != null && !code.isEmpty()) {
            return userService.getUsersByProvinceCode(code);
        } else if (name != null && !name.isEmpty()) {
            return userService.getUsersByProvinceName(name);
        }
        throw new RuntimeException("Please provide either province code or name");
    }

    @GetMapping("/by-location/{locationId}")
    public List<User> getUsersByLocation(@PathVariable UUID locationId) {
        return userService.getUsersByLocationId(locationId);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
