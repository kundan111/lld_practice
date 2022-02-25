package io.binactivate.model.parkinglot;

import io.binactivate.model.vehicle.VehicleEnum;

public class ElectricVehicleSlot extends VehicleSlot{

    public ElectricVehicleSlot(boolean isForAbledPeople) {
        super(VehicleEnum.ELECTRIC, isForAbledPeople);
    }
    
}
