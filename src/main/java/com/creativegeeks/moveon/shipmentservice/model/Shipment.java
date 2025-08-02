package com.creativegeeks.moveon.shipmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents a single shipment. This class is an entity that will be mapped to a database table.
 * It uses Lombok annotations to automatically generate boilerplate code like getters, setters,
 * and constructors.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Origin cannot be blank")
    private String origin;

    @NotBlank(message = "Destination cannot be blank")
    private String destination;

    @NotBlank(message = "Load type cannot be blank")
    private String loadType;

    @NotNull(message = "Weight cannot be null")
    private Double weight;

    private String dimensions; // Optional field for dimensions

    private String specialInstructions; // Optional field for special instructions

    @Enumerated(EnumType.STRING)
    @NotNull
    private ShipmentStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }
}
