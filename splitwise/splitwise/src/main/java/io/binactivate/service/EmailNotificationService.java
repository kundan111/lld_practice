package io.binactivate.service;

import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;

public class EmailNotificationService implements NotificationService{

    @Override
    public void notifyUser(User user, ExpenseGroup expenseGroup) {
        StringBuilder body = new StringBuilder();
        User giver = expenseGroup.getGiver();
        Double amount = user.getBalances().get(giver);

        System.out.println("amount is: " + amount);
        
        if(amount < 0)
        {
            body.append("you owe " + giver + amount + " !");
            System.out.println("Email sent with body " + body.toString() + " to " + user.getEmail());
        }else{
            body.append(giver + " owe you " + amount + " !");
            System.out.println("Email sent with body " + body.toString() + " to " + user.getEmail());
        }
        
        
    }
    
}
