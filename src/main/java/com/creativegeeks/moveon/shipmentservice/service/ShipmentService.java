package com.creativegeeks.moveon.shipmentservice.service;

import com.creativegeeks.moveon.shipmentservice.model.Shipment;
import com.creativegeeks.moveon.shipmentservice.model.ShipmentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The interface Shipment service.
 */
@Service
public interface ShipmentService {
    /**
     * Create shipment.
     *
     * @param shipment the shipment
     * @return the shipment
     */
    Shipment createShipment(Shipment shipment);

    /**
     * Gets shipment by id.
     *
     * @param id the id
     * @return the shipment by id
     */
    Optional<Shipment> getShipmentById(Long id);

    /**
     * Gets all shipments.
     *
     * @return the all shipments
     */
    List<Shipment> getAllShipments();

    /**
     * Update shipment status optional.
     *
     * @param id        the id
     * @param newStatus the new status
     * @return the optional
     */
    Optional<Shipment> updateShipmentStatus(Long id, ShipmentStatus newStatus);

    /**
     * Delete shipment.
     *
     * @param id the id
     */
    void deleteShipment(Long id);
}
