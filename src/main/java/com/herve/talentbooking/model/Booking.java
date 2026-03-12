package com.herve.talentbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;
    private String status;

    @ManyToOne
    @JoinColumn(name="event_id")
    @JsonIgnoreProperties({"client", "bookings"})
    private Event event;

    @ManyToOne
    @JoinColumn(name ="talent_id")
    @JsonIgnoreProperties({"user", "bookings"})
    private TalentProfile talent;
}
