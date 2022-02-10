package io.binactivate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import io.binactivate.service.EqualSplitType;
import io.binactivate.service.ExactSplitType;
import io.binactivate.service.PercentSplitType;
import io.binactivate.service.SplitType;

public class ExpenseGroup {
    
    private double transactionAmount;
    private User giver;
    private List<User> takers;
    private SplitType splittype;

    private HashMap<User,Double> exactSplit;
    private HashMap<User,Integer> percentSplit;

    public double getTransactionAmount() {
        return transactionAmount;
    }
    public ExpenseGroup() {
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
    public List<User> getTakers() {
        return takers;
    }
    public void setTakers(List<User> takers) {
        this.takers = takers;
    }
    public SplitType getSplittype() {
        return splittype;
    }
    public void setSplittype(String splittype) {

        if(splittype.equals("EXACT"))
        {
            this.splittype = new ExactSplitType(this);
        }else if(splittype.equals("PERCENT"))
        {
            this.splittype = new PercentSplitType(this);
        }else if(splittype.equals("EQUAL")) {
            this.splittype = new EqualSplitType(this);
        }else{
            throw new IllegalArgumentException("Invalid splittype given");
        }

        
        Scanner sc = new Scanner(System.in);
        if(this.splittype instanceof ExactSplitType)
        {
            for (User user : takers) {
                System.out.println("Enter exact amount for " + user.getName());
                double nextDoubleInp = sc.nextDouble();
                exactSplit.put(user,nextDoubleInp );
            }
        }else if(this.splittype instanceof PercentSplitType)
        {
            for (User user : takers) {
                System.out.println("Enter percent for " + user.getName());
                int nextIntInp = sc.nextInt();
                
                percentSplit.put(user,nextIntInp);
            }
        }
        // sc.close();
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
