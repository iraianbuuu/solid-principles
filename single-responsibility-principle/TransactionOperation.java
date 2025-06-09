import java.math.BigDecimal;

public class TransactionOperation {
    public void deposit(int accountNumber, BigDecimal amount) {
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setBalance(account.getBalance().add(amount));
    }

    public void withdraw(int accountNumber, BigDecimal amount) {
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setBalance(account.getBalance().subtract(amount));
    }
}