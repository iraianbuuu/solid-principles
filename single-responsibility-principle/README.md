## Introduction

SOLID is an acronym for the five principles of object-oriented design by Robert C. Martin (Uncle Bob).
In this article, we will discuss the Single Responsibility Principle (SRP) and how it can be applied to Java.

## Single Responsibility Principle

The **Single Responsibility Principle (SRP)** states that a module (Set of function, classes or packages)
should be responsible to one, and only one, actor.
An actor is any individual, group, or other system that interacts with the system in a way and may call for modifications to the module.

> [!NOTE]
> A class should have one and only one reason to change

## Example

Consider this Java implementation that violates SRP:

```java
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

    // This method violates the Single Responsibility Principle
    public void deposit(int accountNumber, BigDecimal amount) {
        Account account = getAccount(accountNumber);
        account.setBalance(account.getBalance().add(amount));
    }
}
```

This class has methods for two distinct responsibilities:

- Account management: `addAccount`, `getAccount`, `updateAccount`, `removeAccount`
- Transaction processing: `deposit`

### The Problem

This class violates SRP because it has multiple responsibilities that would be of interest to different stakeholders:

1. The Account Management team would request changes to the account management methods
2. The Transaction Processing team would request changes to the transaction methods

If you change a transaction method and accidentally break account management functionality, you've created a problem for a team that didn't request any changes.

### Better Design

Following SRP, we separate these responsibilities:

```java
// Responsible for account management operations
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
}

// Responsible for transaction operations
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
```

Now each class has a single responsibility and will change only when requested by its respective stakeholder.

## Benefits

1. **Maintainability**: Changes in one responsibility won't affect other responsibilities
2. **Testability**: Easier to write focused unit tests
3. **Readability**: Classes and methods become more focused and easier to understand
4. **Reusability**: Single-responsibility components are more likely to be reusable

## Conclusion

The Single Responsibility Principle helps us create more maintainable code by separating concerns based on who might request changes.
As Uncle Bob puts it: **"Gather together the things that change for the same reasons. Separate those things that change for different reasons."**
