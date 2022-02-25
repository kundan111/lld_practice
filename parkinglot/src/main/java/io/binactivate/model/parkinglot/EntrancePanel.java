package io.binactivate.model.parkinglot;

import java.util.UUID;

import io.binactivate.model.user.ParkingAttendant;

public class EntrancePanel {
    
    private String entrancePanelId;
    private DisplayBoard displayBoard;
    private ParkingAttendant parkingAttendant;


    public EntrancePanel(DisplayBoard displayBoard, ParkingAttendant parkingAttendant) {
        this.entrancePanelId = UUID.randomUUID().toString();
        this.displayBoard = displayBoard;
        this.parkingAttendant = parkingAttendant;
    }


    
}
