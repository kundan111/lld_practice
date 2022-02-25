package io.binactivate.model.parkinglot;

import io.binactivate.model.vehicle.VehicleEnum;

public class CarSlot extends VehicleSlot{

    public CarSlot(boolean isForAbledPeople) {
        super(VehicleEnum.CAR, isForAbledPeople);
    }
    
}
