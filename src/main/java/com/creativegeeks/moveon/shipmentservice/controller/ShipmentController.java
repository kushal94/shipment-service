package com.creativegeeks.moveon.shipmentservice.controller;

import com.creativegeeks.moveon.shipmentservice.model.Shipment;
import com.creativegeeks.moveon.shipmentservice.model.ShipmentStatus;
import com.creativegeeks.moveon.shipmentservice.service.ShipmentService;
import com.creativegeeks.moveon.shipmentservice.service.ShipmentServiceImpl;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The REST controller for managing shipments.
 * It defines the API endpoints for creating, retrieving, updating, and deleting shipments.
 */
@RestController
@RequestMapping("/api/v1/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    @NonNull
    private final ShipmentService shipmentService;

    /**
     * Creates a new shipment.
     *
     * @param shipment The shipment details provided in the request body.
     * @return The created shipment with a 200 OK status.
     */
    @PostMapping
    public Shipment createShipment(@Valid @RequestBody Shipment shipment) {
        return shipmentService.createShipment(shipment);
    }

    /**
     * Retrieves a shipment by its ID.
     *
     * @param id The ID of the shipment.
     * @return A ResponseEntity with the shipment if found, or a 404 Not Found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id) {
        Optional<Shipment> shipment = shipmentService.getShipmentById(id);
        return shipment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all shipments.
     *
     * @return A list of all shipments with a 200 OK status.
     */
    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    /**
     * Updates the status of a shipment.
     *
     * @param id The ID of the shipment to update.
     * @param newStatus The new status to be set.
     * @return A ResponseEntity with the updated shipment, or a 404 Not Found status.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<Shipment> updateShipmentStatus(@PathVariable Long id, @RequestBody ShipmentStatus newStatus) {
        Optional<Shipment> updatedShipment = shipmentService.updateShipmentStatus(id, newStatus);
        return updatedShipment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a shipment by its ID.
     *
     * @param id The ID of the shipment to delete.
     * @return A 204 No Content status if successful, or a 404 Not Found status if the shipment doesn't exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        if (shipmentService.getShipmentById(id).isPresent()) {
            shipmentService.deleteShipment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
