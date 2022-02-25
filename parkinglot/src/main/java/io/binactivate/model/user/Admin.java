package io.binactivate.model.user;

import io.binactivate.service.ParkingLotService;

public class Admin extends Account{

    ParkingLotService parkingLotService = ParkingLotService.getInstance();

    private boolean isAdmin = true;
    public Admin(String firstName, String middleName, String lastName, Address address) {
        super(firstName, middleName, lastName, address);
    }


    public void addFloor()
    {
        parkingLotService.addFloorService(this);
    }
    
}
