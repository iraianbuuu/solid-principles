import java.math.BigDecimal;

public class Main {
    public static void main(String... args) {
        AccountOperations accountOperations = new AccountOperations();
        Account account = new Account(1, "Iraianbuu", new BigDecimal("1000.00"));
        accountOperations.addAccount(account);

        TransactionOperation transactionOperation = new TransactionOperation();
        transactionOperation.deposit(1, new BigDecimal("100.00"));
        System.out.println(account.toString());
    }
}