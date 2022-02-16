package io.binactivate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import io.binactivate.exception.IllegalUserGivenForCurrentExpenseGroupException;
import io.binactivate.exception.InsufficientContributionCountGivenException;
import io.binactivate.exception.SplitTypeNotSetException;
import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.SplitTypeEnum;
import io.binactivate.model.User;
import io.binactivate.service.ExpenseService;
import io.binactivate.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    static ExpenseService expenseService;
    static UserService userService;
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        
        // intialising user service
        userService = new UserService();
        
        // intialising expense service
        expenseService = new ExpenseService();


        User u1 = userService.createUser("Kundan", "kundan@gmail.com");
        User u2 = userService.createUser("Swaraj", "swaraj@gmail.com");
        User u3 = userService.createUser("Abhinav", "abhinav@gmail.com");
        User u4 = userService.createUser("Anshil", "anshil@gmail.com");
        User u5 = userService.createUser("Saket", "saket@gmail.com");




        ExpenseGroup eg = null;
        try {
        		// 	Equal splittype
                Set<User> takers = new HashSet<>();
                takers.add(u1);
                takers.add(u2);
                takers.add(u3);
                takers.add(u4);
             
                eg = expenseService.createExpenseGroup(u1, takers, 1000.0, SplitTypeEnum.EQUAL, null);
                expenseService.updateBalanceForAllUsersInExpenseGroup(eg);
                printBalance(eg);
                
                System.out.println("========================================");
                
                // exact splittype
                
                takers.clear();
                takers.add(u2);
                takers.add(u3);
                
                HashMap<User, Double> contriHashMap = new HashMap<>();
                contriHashMap.put(u2, 370.0);
                contriHashMap.put(u3, 880.0);
                
                
                eg = expenseService.createExpenseGroup(u1, takers, 1250.0, SplitTypeEnum.EXACT, contriHashMap);
                expenseService.updateBalanceForAllUsersInExpenseGroup(eg);
                printBalance(eg);
                
                System.out.println("========================================");
                
                
             // percent splittype
                takers.clear();
                
                takers.add(u1);
                takers.add(u2);
                takers.add(u3);
                takers.add(u4);
                
                contriHashMap.clear();
                
                contriHashMap.put(u1, 40.0);
                contriHashMap.put(u2, 20.0);
                contriHashMap.put(u3, 20.0);
                contriHashMap.put(u4, 20.0);
                
                eg = expenseService.createExpenseGroup(u1, takers, 1200, SplitTypeEnum.PERCENT, contriHashMap);
                expenseService.updateBalanceForAllUsersInExpenseGroup(eg);
                printBalance(eg);

                System.out.println("========================================");

                for (User user : takers) {
                    System.out.println(user.getUserId() + " -> " + user.getName());
                }
                

        } catch (SplitTypeNotSetException | InsufficientContributionCountGivenException
                | IllegalUserGivenForCurrentExpenseGroupException e) {
            e.printStackTrace();
        }


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
