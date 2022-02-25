package io.binactivate;

import io.binactivate.model.user.Admin;
import io.binactivate.model.user.Customer;
import io.binactivate.model.vehicle.VehicleEnum;
import io.binactivate.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    private static UserService userService = new UserService();
    public static void main( String[] args )
    {
        Admin admin = (Admin)userService.createAdmin("Kundan", "", "Ranjan", "kundan.ranjan@ericsson.com");
        Customer cus = (Customer)userService.createCustomer("firstName", "", "lastName", "email", false, VehicleEnum.CAR, "asdas");
        
        admin.addFloor();
        

    }
}
