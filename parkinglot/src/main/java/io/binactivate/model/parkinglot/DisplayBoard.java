package io.binactivate.model.parkinglot;

import java.util.HashMap;
import java.util.UUID;
import java.util.Map.Entry;

import io.binactivate.exceptions.IllegalFloorIdPassed;
import io.binactivate.model.user.Account;
import io.binactivate.model.vehicle.VehicleEnum;

public class DisplayBoard {
    
    private String displayBoardId;
    private HashMap<VehicleSlot,Account> availableSlots;
    private String floorId;

    public DisplayBoard(String floorId) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        if(!parkingLot.getParkingfloor().containsKey(floorId))
        {
            throw new IllegalFloorIdPassed("wrong floor id passed");
        }

        this.floorId = floorId;
        this.displayBoardId = UUID.randomUUID().toString();
        this.availableSlots = ParkingLot.getInstance().getParkingfloor().get(this.floorId).getAvailableSlots();
    }

    public String getDisplayBoardId() {
        return displayBoardId;
    }

    public HashMap<VehicleSlot, Account> getAvailableSlots() {
        return availableSlots;
    }

    
    public String getFloorId() {
        return floorId;
    }

    private HashMap<VehicleEnum,Integer> displayUtil()
    {
        HashMap<VehicleEnum,Integer> status = new HashMap<>();
        for (Entry<VehicleSlot, Account> e: availableSlots.entrySet()) {
            
            VehicleSlot key = e.getKey();
            Account value = e.getValue();

            if(value == null)
            {
                if(status.containsKey(key.getVehicleSlotFor()))
                {
                    int prev = status.get(key.getVehicleSlotFor());
                    status.put(key.getVehicleSlotFor(), prev+1);
                }else{
                    status.put(key.getVehicleSlotFor(), 1);
                }
            }

        }

        return status;
    }

    public void display()
    {
        HashMap<VehicleEnum, Integer> displayUtil = displayUtil();

        System.out.println("========= AVAIABLE SLOTS for " + displayBoardId +" ==========");
        for (Entry<VehicleEnum, Integer> e: displayUtil.entrySet()) {
            System.out.println(e.getKey().toString() + " -> " + e.getValue());
        }
        System.out.println("=============================================================");

    }
    

}
