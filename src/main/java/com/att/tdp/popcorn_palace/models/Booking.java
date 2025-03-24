package com.att.tdp.popcorn_palace.models;

import lombok.Data;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // no need for referencedColumnName as we reference the PK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", nullable = false, foreignKey = @ForeignKey(name = "fk_booking_showtime"))
    private Showtime showtime;

    @Column(nullable = false, name = "seat_number")
    private Integer seatNumber;

    @Column(nullable = false, name = "user_id")
    private UUID userId;
}
