
package io.binactivate.service;

import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;

public class EqualSplitType implements SplitType{

    ExpenseGroup expenseGroup;

    @Override
    public double getPart(User user) {
        
        int totalPeople = expenseGroup.getTotalUserInvolvedforExpense();
        double txAmount = expenseGroup.getTransactionAmount();

        return txAmount/totalPeople;
    }

    public EqualSplitType(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    
    
}
