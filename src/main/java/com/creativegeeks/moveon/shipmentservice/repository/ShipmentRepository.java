package com.creativegeeks.moveon.shipmentservice.repository;

import com.creativegeeks.moveon.shipmentservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository interface for managing Shipment entities.
 * Spring Data JPA automatically provides CRUD (Create, Read, Update, Delete) operations
 * for the Shipment entity.
 */
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
