package com.herve.talentbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String code;
    private String type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties({"parent", "children", "users"})
    private Location parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<Location> children;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<User> users;
}
