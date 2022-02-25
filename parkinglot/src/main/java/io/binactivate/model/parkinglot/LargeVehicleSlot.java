package io.binactivate.model.parkinglot;

import io.binactivate.model.vehicle.VehicleEnum;

public class LargeVehicleSlot extends VehicleSlot{

    public LargeVehicleSlot(boolean isForAbledPeople) {
        super(VehicleEnum.LARGE_VEHICLE, isForAbledPeople);
    }
    
}
