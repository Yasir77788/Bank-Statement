// domain class models the bank statement
// which can be used by different parts
// of the application
package bankst;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction
{
    private final LocalDate date;
    private final double amount;
    private final String description;
    
    public BankTransaction (final LocalDate date, final double amount, final String description)
    {
        this.date = date;
        this.amount = amount;
        this.description = description;
        
    }
    
    public LocalDate getDate()
    {
        return date;
    }
    public double getAmount()
    {
        return amount;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    @Override
    public String toString()
    {
        return "BankTransaction{" +
               "date = " + date +
                ", amount = " + amount +
                ", description = '" + description + '\'' +
                '}';
    }
    
    @Override
    public boolean equals (Object passedObj)
    {
        if(this == passedObj) return true;
        if (passedObj == null || getClass() != passedObj.getClass()) return false;
        
        BankTransaction castObj = (BankTransaction) passedObj;
        return Double.compare(castObj.amount, amount) == 0 &&
                date.equals (castObj.date) &&
                description.equals(castObj.description);
    }
    
    @Override
    public int hashCode() 
    {
        return Objects.hash(date, amount, description);
    }
}