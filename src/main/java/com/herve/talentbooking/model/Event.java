package com.herve.talentbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private LocalDate eventDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"location", "roles", "talentProfile", "events", "password"})
    private User client;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private java.util.List<Booking> bookings;
}
