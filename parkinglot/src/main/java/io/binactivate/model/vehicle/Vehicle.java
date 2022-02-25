package io.binactivate.model.vehicle;

public abstract class Vehicle {
    
    private String licenseNumber;
    private VehicleEnum vehicleEnum;

    public Vehicle(String licenseNumber, VehicleEnum vehicleEnum) {
        this.licenseNumber = licenseNumber;
        this.vehicleEnum = vehicleEnum;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    
    public VehicleEnum getVehicleEnum() {
        return vehicleEnum;
    }

    
}
