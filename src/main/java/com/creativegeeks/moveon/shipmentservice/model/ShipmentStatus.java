package com.creativegeeks.moveon.shipmentservice.model;

public enum ShipmentStatus {
    REQUESTED, // A new shipment request has been created
    BOOKED,    // The shipment has been booked by a carrier
    IN_TRANSIT, // The shipment is currently being transported
    DELIVERED, // The shipment has been delivered to its destination
    COMPLETED, // The shipment process is finalized (e.g., payment processed)
    CANCELLED  // The shipment has been cancelled
}