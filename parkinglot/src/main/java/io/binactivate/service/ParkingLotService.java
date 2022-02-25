package io.binactivate.service;

import io.binactivate.exceptions.ActionNotAllowed;
import io.binactivate.model.parkinglot.ParkingFloor;
import io.binactivate.model.parkinglot.ParkingLot;
import io.binactivate.model.user.Account;
import io.binactivate.model.user.Admin;

public class ParkingLotService {
    
    private static ParkingLotService parkingLotService;
    private ParkingLot parkingLot;

    private ParkingLotService()
    {
        parkingLot = ParkingLot.getInstance();
    }

    public static ParkingLotService getInstance()
    {
        if(parkingLotService != null)
        {
            return parkingLotService;
        }

        return parkingLotService = new ParkingLotService();
    }

    public void addFloorService(Account user)
    {
        if(!(user instanceof Admin))
        {
            throw new ActionNotAllowed("only admins can perform this action");
        }

        ParkingFloor newParkingFloor = new ParkingFloor();
        parkingLot.getParkingfloor().put(newParkingFloor.getParkingFloorId(), newParkingFloor);

    }




}
