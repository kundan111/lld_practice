package io.binactivate;

import java.util.ArrayList;
import java.util.List;

import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;
import io.binactivate.repository.UserRepository;
import io.binactivate.service.ExpenseManager;
import io.binactivate.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        UserService userService = new UserService();
        User u1 = userService.createUser("Kundan", "kundan@gmail.com");
        User u2 = userService.createUser("Swaraj", "swaraj@gmail.com");
        User u3 = userService.createUser("Abhinav", "abhinav@gmail.com");
        User u4 = userService.createUser("Anshil", "anshil@gmail.com");
        User u5 = userService.createUser("Saket", "saket@gmail.com");




        // Equal splittype
        ExpenseGroup eg1 = new ExpenseGroup();
        List<User> takers1 = new ArrayList<>();
        takers1.add(u1);
        takers1.add(u2);
        takers1.add(u3);
        takers1.add(u4);
        

        eg1.setTakers(takers1);
        eg1.setGiver(u1);
        eg1.setSplittype("EQUAL");
        eg1.setTransactionAmount(1000);

        
        ExpenseManager expenseManager1 = new ExpenseManager();
        expenseManager1.updateBalanceForAllUsers(eg1);

        printBalance(eg1);


        System.out.println("========================================");

        
        
        // exact splittype
        ExpenseGroup eg3 = new ExpenseGroup();
        List<User> takers3 = new ArrayList<>();
        takers3.add(u2);
        takers3.add(u3);
        eg3.setTakers(takers3);
        
        eg3.setGiver(u1);
        eg3.setSplittype("EXACT");
        eg3.setTransactionAmount(1250);

        ExpenseManager expenseManager3 = new ExpenseManager();
        expenseManager3.updateBalanceForAllUsers(eg3);

        printBalance(eg3);    

        System.out.println("========================================");
        // percent splittype
        
        ExpenseGroup eg2 = new ExpenseGroup();
        List<User> takers2 = new ArrayList<>();
        takers2.add(u1);
        takers2.add(u2);
        takers2.add(u3);
        takers2.add(u4);
        eg2.setTakers(takers2);
        
        eg2.setGiver(u4);
        eg2.setSplittype("PERCENT");
        eg2.setTransactionAmount(1200);

        ExpenseManager expenseManager2 = new ExpenseManager();
        expenseManager2.updateBalanceForAllUsers(eg2);

        printBalance(eg2);    
        

    }


    static void printBalance(ExpenseGroup eg)
    {
        for(User u : eg.getTakers())
        {
            System.out.println("Printing for: " + u.getName() );
            System.out.println(u.getBalances());
        }
    }

    
}
