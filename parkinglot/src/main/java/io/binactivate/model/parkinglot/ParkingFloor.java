package io.binactivate.model.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import io.binactivate.model.user.Account;


public class ParkingFloor {
    
    private String parkingFloorId;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    

    public ParkingFloor() {
        this.parkingFloorId = UUID.randomUUID().toString();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
        this.availableSlots = new HashMap<>();
    }

    private HashMap<VehicleSlot,Account> availableSlots;

    public String getParkingFloorId() {
        return parkingFloorId;
    }

    public void setParkingFloorId(String parkingFloorId) {
        this.parkingFloorId = parkingFloorId;
    }

    public List<EntrancePanel> getEntrancePanels() {
        return entrancePanels;
    }

    public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
        this.entrancePanels = entrancePanels;
    }

    public List<ExitPanel> getExitPanels() {
        return exitPanels;
    }

    public void setExitPanels(List<ExitPanel> exitPanels) {
        this.exitPanels = exitPanels;
    }

    public HashMap<VehicleSlot, Account> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(HashMap<VehicleSlot, Account> availableSlots) {
        this.availableSlots = availableSlots;
    }

    
    

}
