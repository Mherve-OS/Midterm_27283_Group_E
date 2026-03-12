package com.herve.talentbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column (unique = true)
    private String email;

    private String password;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties({"children", "users", "parent"})
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private TalentProfile talentProfile;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private java.util.List<Event> events;
}
