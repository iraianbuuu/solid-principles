import java.math.BigDecimal;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private BigDecimal balance;

    public Account(int accountNumber, String accountHolderName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() { 
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [AccountNumber=" + accountNumber + ", AccountHolderName=" + accountHolderName + ", Balance=" + balance + "]";
    }

    
}