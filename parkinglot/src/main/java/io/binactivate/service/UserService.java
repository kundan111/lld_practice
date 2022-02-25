package io.binactivate.service;

import io.binactivate.model.user.Account;
import io.binactivate.model.user.Address;
import io.binactivate.model.user.Admin;
import io.binactivate.model.user.Customer;
import io.binactivate.model.vehicle.Car;
import io.binactivate.model.vehicle.Electric;
import io.binactivate.model.vehicle.LargeVehicle;
import io.binactivate.model.vehicle.MotorBike;
import io.binactivate.model.vehicle.Vehicle;
import io.binactivate.model.vehicle.VehicleEnum;
import io.binactivate.repository.UserRepository;

public class UserService {
    public Account createCustomer(String firstName, String middleName, String lastName, String email, 
    boolean isAbled, VehicleEnum vehicleEnum, String licenseNumber
    )
    {
        if(UserRepository.users.containsKey(email))
        {
            return UserRepository.users.get(email);
        }
        Vehicle vehicle = null;
        if(vehicleEnum == VehicleEnum.CAR)
        {
            vehicle = new Car(licenseNumber);

        }else if(vehicleEnum == VehicleEnum.ELECTRIC)
        {
            vehicle = new Electric(licenseNumber);

        }else if(vehicleEnum == VehicleEnum.LARGE_VEHICLE)
        {
            vehicle = new LargeVehicle(licenseNumber);

        }else if(vehicleEnum == VehicleEnum.MOTORBIKE)
        {
            vehicle = new MotorBike(licenseNumber);
        }

        Address add = new Address("dummy 1", "dummy 2", "dummy 3", "KA", "5643307");
        
        Customer newCustomer = new Customer(firstName, middleName, lastName, add, isAbled, vehicle);

        UserRepository.users.put(email, newCustomer);

        return newCustomer;

    }

    public Account createAdmin(String firstName, String middleName, String lastName, String email)
    {
        if(UserRepository.users.containsKey(email))
        {
            return UserRepository.users.get(email);
        }

        Address add = new Address("Admin dummy 1", "Admin dummy 2", "Admin dummy 3", "KA", "5643307");
        Admin newAdmin = new Admin(firstName, middleName, lastName, add);

        UserRepository.users.put(email, newAdmin);

        return newAdmin;
    }



}
