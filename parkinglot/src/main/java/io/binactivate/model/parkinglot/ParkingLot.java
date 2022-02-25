package io.binactivate.model.parkinglot;

import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {

    private String parkingLotId;
    private HashMap<String,ParkingFloor> parkingfloor;
    
    private static ParkingLot instance;

    private ParkingLot() {

        this.parkingLotId = UUID.randomUUID().toString();
        this.parkingfloor = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance()
    {
        if(instance != null)
        {
            return instance;
        }

        return instance = new ParkingLot();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }


    public HashMap<String, ParkingFloor> getParkingfloor() {
        return parkingfloor;
    }

    

    
}
