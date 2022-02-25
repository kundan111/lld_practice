package io.binactivate.model.user;

import io.binactivate.model.vehicle.Vehicle;

public class Customer extends Account{

    private boolean isAbled;
    private Vehicle customerVehicle;
    public Customer(String firstName, String middleName, String lastName, Address address, boolean isAbled, Vehicle customerVehicle ) {
        super(firstName, middleName, lastName, address);
        this.isAbled = isAbled;
        this.customerVehicle = customerVehicle;
    }
    public boolean isAbled() {
        return isAbled;
    }
    public Vehicle getCustomerVehicle() {
        return customerVehicle;
    }
    
}
