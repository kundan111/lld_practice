package io.binactivate.service;

import io.binactivate.exception.IllegalExactSplitGiven;
import io.binactivate.exception.IllegalPercentSplitGiven;
import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;

public class ExpenseManager {
    private ExpenseGroup expenseGroup;

    public ExpenseManager(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }


    public void updateBalanceForUser() 
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
                }
                
                
            } catch (IllegalExactSplitGiven | IllegalPercentSplitGiven e) {
                
                System.out.println(e.getClass().getName() + " : " + e.getMessage());
            }
        }
    }
    
}
