package io.binactivate.model.parkinglot;

import java.util.UUID;

import io.binactivate.model.vehicle.Vehicle;
import io.binactivate.model.vehicle.VehicleEnum;

public abstract class VehicleSlot {
    
    private String vehicleSlotId;
    private VehicleEnum vehicleSlotFor;
    private Vehicle vehicleSlotOccupiedBy;
    private boolean isVacant;
    private boolean isForAbledPeople;

    
    public VehicleSlot( VehicleEnum vehicleSlotFor, boolean isForAbledPeople) {
        this.vehicleSlotId = UUID.randomUUID().toString();
        this.vehicleSlotFor = vehicleSlotFor;
        this.isVacant = true;
        this.isForAbledPeople = isForAbledPeople;
    }


    public String getVehicleSlotId() {
        return vehicleSlotId;
    }

    public VehicleEnum getVehicleSlotFor() {
        return vehicleSlotFor;
    }


    public boolean isVacant() {
        return isVacant;
    }


    public void setVacant(boolean isVacant) {
        this.isVacant = isVacant;
    }

    public Vehicle getVehicleSlotOccupiedBy() {
        return vehicleSlotOccupiedBy;
    }


    public void setVehicleSlotOccupiedBy(Vehicle vehicleSlotOccupiedBy) {
        this.vehicleSlotOccupiedBy = vehicleSlotOccupiedBy;
    }

    public boolean isForAbledPeople() {
        return isForAbledPeople;
    }

}
