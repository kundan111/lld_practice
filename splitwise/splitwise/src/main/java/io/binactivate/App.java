package io.binactivate;

import java.util.ArrayList;
import java.util.List;

import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;
import io.binactivate.service.ExpenseManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        //creating users
        User u1 = new User("u1", "Kundan", "kundan@gmail.com");
        User u2 = new User("u2", "Swaraj", "swaraj@gmail.com");
        User u3 = new User("u3", "Abhinav", "abhinav@gmail.com");
        User u4 = new User("u4", "Anshil", "anshil@gmail.com");
        User u5 = new User("u5", "Saket", "saket@gmail.com");


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

        
        ExpenseManager expenseManager1 = new ExpenseManager(eg1);
        expenseManager1.updateBalanceForUser();

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

        ExpenseManager expenseManager3 = new ExpenseManager(eg3);
        expenseManager3.updateBalanceForUser();

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

        ExpenseManager expenseManager2 = new ExpenseManager(eg2);
        expenseManager2.updateBalanceForUser();

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
