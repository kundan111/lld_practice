package io.binactivate.model;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

import io.binactivate.exception.IllegalUserGivenForCurrentExpenseGroupException;
import io.binactivate.exception.InsufficientContributionCountGivenException;
import io.binactivate.exception.SplitTypeNotSetException;
import io.binactivate.service.EqualSplitType;
import io.binactivate.service.ExactSplitType;
import io.binactivate.service.PercentSplitType;
import io.binactivate.service.SplitType;

public class ExpenseGroup {
    
    private String expenseGroupId;
    private double transactionAmount;
    private User giver;
    private Set<User> takers;
    private SplitType splittype;

    public String getExpenseGroupId() {
        return expenseGroupId;
    }
    
    private HashMap<User,Double> exactSplit;
    private HashMap<User,Integer> percentSplit;

    public double getTransactionAmount() {
        return transactionAmount;
    }
    public ExpenseGroup() {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.exactSplit = new HashMap<>();
        this.percentSplit = new HashMap<>();
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public User getGiver() {
        return giver;
    }
    public void setGiver(User giver) {
        this.giver = giver;
    }
    public Set<User> getTakers() {
        return takers;
    }
    public void setTakers(Set<User> takers) {
        this.takers = takers;
    }
    public SplitType getSplittype() {
        return splittype;
    }
    public void setSplittype(SplitTypeEnum splittype) {

        if(splittype.equals(SplitTypeEnum.EXACT))
        {
            this.splittype = new ExactSplitType(this);
        }else if(splittype.equals(SplitTypeEnum.PERCENT))
        {
            this.splittype = new PercentSplitType(this);
        }else if(splittype.equals(SplitTypeEnum.EQUAL)) {
            this.splittype = new EqualSplitType(this);
        }else{
            throw new IllegalArgumentException("Invalid splittype given");
        }

    }

    public void setAppropriateValuesForSplitType(HashMap<User,Double> userContri ) throws SplitTypeNotSetException, InsufficientContributionCountGivenException
    ,IllegalUserGivenForCurrentExpenseGroupException
    {
        if(this.splittype == null)
        {
            throw new SplitTypeNotSetException("set splittype before setting values for users");
        }

        if(this.splittype instanceof EqualSplitType && userContri == null)
        {
            return;
        }

        int takerCount = this.getTotalUserInvolvedforExpense();
        if(userContri.size() != takerCount)
        {
            throw new InsufficientContributionCountGivenException("all users contri not provided");
        }

        
        for (Entry<User,Double> userContriPair : userContri.entrySet()) {
            
            User contriUser = userContriPair.getKey();
            Double contriUserContribution = userContriPair.getValue();

            if(!this.getTakers().contains(userContriPair.getKey()))
            {
                throw new IllegalUserGivenForCurrentExpenseGroupException("given user not part of this expense group");
            }
            if(this.splittype instanceof PercentSplitType)
            {
                this.getPercentSplit().put(contriUser, contriUserContribution.intValue());
            }else if(this.splittype instanceof ExactSplitType)
            {
                this.getExactSplit().put(contriUser, contriUserContribution);
            }

        }
        


    }

    public HashMap<User, Double> getExactSplit() {
        return exactSplit;
    }
    public void setExactSplit(HashMap<User, Double> exactSplit) {
        this.exactSplit = exactSplit;
    }
    public HashMap<User, Integer> getPercentSplit() {
        return percentSplit;
    }
    public void setPercentSplit(HashMap<User, Integer> percentSplit) {
        this.percentSplit = percentSplit;
    }
    public int getTotalUserInvolvedforExpense()
    {
        return takers.size();
    }

}
