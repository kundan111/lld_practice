package io.binactivate.model.parkinglot;

import io.binactivate.model.vehicle.VehicleEnum;

public class MotorBikeSlot extends VehicleSlot{

    public MotorBikeSlot(boolean isForAbledPeople) {
        super(VehicleEnum.MOTORBIKE, isForAbledPeople);
    }
    
}
