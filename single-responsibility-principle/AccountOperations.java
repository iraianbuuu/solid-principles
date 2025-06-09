import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class AccountOperations {
    private static Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void updateAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber);
    }

    /** 
     * Adding this method violates the Single Responsibility Principle
     * Move this method to a separate class TransactionOperation
     */
    public void deposit(int accountNumber, BigDecimal amount) {
    }
}
    