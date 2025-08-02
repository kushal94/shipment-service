package com.creativegeeks.moveon.shipmentservice.service;

import com.creativegeeks.moveon.shipmentservice.model.Shipment;
import com.creativegeeks.moveon.shipmentservice.model.ShipmentStatus;
import com.creativegeeks.moveon.shipmentservice.repository.ShipmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The service layer for handling business logic related to shipments.
 * It interacts with the ShipmentRepository to perform data operations.
 */
@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    @NonNull
    private final ShipmentRepository shipmentRepository;

    /**
     * Creates a new shipment.
     *
     * @param shipment The shipment object to create.
     * @return The created shipment with its assigned ID.
     */
    public Shipment createShipment(Shipment shipment) {
        // Set the initial status for a new shipment request
        shipment.setStatus(ShipmentStatus.REQUESTED);
        return shipmentRepository.save(shipment);
    }

    /**
     * Retrieves a shipment by its unique ID.
     *
     * @param id The ID of the shipment.
     * @return An Optional containing the shipment if found, otherwise empty.
     */
    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    /**
     * Retrieves all shipments.
     *
     * @return A list of all shipments.
     */
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    /**
     * Updates the status of a specific shipment.
     *
     * @param id The ID of the shipment to update.
     * @param newStatus The new status to be set.
     * @return An Optional containing the updated shipment if found, otherwise empty.
     */
    public Optional<Shipment> updateShipmentStatus(Long id, ShipmentStatus newStatus) {
        return shipmentRepository.findById(id)
                .map(shipment -> {
                    shipment.setStatus(newStatus);
                    return shipmentRepository.save(shipment);
                });
    }

    /**
     * Deletes a shipment by its ID.
     *
     * @param id The ID of the shipment to delete.
     */
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
