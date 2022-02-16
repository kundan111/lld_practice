package io.binactivate.service;


import java.util.HashMap;
import java.util.Set;

import io.binactivate.exception.IllegalExactSplitGiven;
import io.binactivate.exception.IllegalPercentSplitGiven;
import io.binactivate.exception.IllegalUserGivenForCurrentExpenseGroupException;
import io.binactivate.exception.InsufficientContributionCountGivenException;
import io.binactivate.exception.SplitTypeNotSetException;
import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.SplitTypeEnum;
import io.binactivate.model.User;

public class ExpenseService {
    // private ExpenseGroup expenseGroup;
    NotificationService notificationService = new EmailNotificationService();

    public ExpenseService() {
        // this.expenseGroup = expenseGroup;
    }

    public ExpenseGroup createExpenseGroup(User giver, Set<User> takers,double transactionAmount, SplitTypeEnum splitTypeEnum, HashMap<User,Double> userContri) throws SplitTypeNotSetException, 
    InsufficientContributionCountGivenException, IllegalUserGivenForCurrentExpenseGroupException
    {
        ExpenseGroup newExpenseGroup = new ExpenseGroup();
        newExpenseGroup.setTakers(takers);
        newExpenseGroup.setGiver(giver);
        newExpenseGroup.setTransactionAmount(transactionAmount);
        newExpenseGroup.setSplittype(splitTypeEnum);
        newExpenseGroup.setAppropriateValuesForSplitType(userContri);
        
        return newExpenseGroup;
    }

    public void updateBalanceForAllUsersInExpenseGroup(ExpenseGroup expenseGroup) 
    {
        User giver = expenseGroup.getGiver();
        for (User taker : expenseGroup.getTakers()) {
            try {
                // update taker
                double part = expenseGroup.getSplittype().getPart(taker);
                if(!giver.equals(taker))
                {
                    if(taker.getBalances().containsKey(giver))
                    {
                        double prevAmt = taker.getBalances().get(giver);
                        taker.getBalances().put(giver, prevAmt-part);
                    }else{
                        taker.getBalances().put(giver, -1*part);
                    }
                
                    
                    // update giver
                    if(giver.getBalances().containsKey(taker))
                    {
                        double prevAmt = giver.getBalances().get(taker);
                        giver.getBalances().put(taker, prevAmt + part);
                    }else{
                        giver.getBalances().put(taker, part);
                    }
                    notificationService.notifyUser(taker, expenseGroup);
                }
                
                
            } catch (IllegalExactSplitGiven | IllegalPercentSplitGiven e) {
                
                e.printStackTrace();
            }
        }
    }
    
}
