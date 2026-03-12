package com.herve.talentbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stageName;
    private String category;
    private String description;
    private Double pricePerEvent;

    @OneToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties({"location", "roles", "talentProfile", "events", "password"})
    private User user;

    @OneToMany(mappedBy = "talent")
    @JsonIgnore
    private java.util.List<Booking> bookings;
}
