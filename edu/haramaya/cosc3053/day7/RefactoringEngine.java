
package edu.haramaya.cosc3053.day7;

import java.util.ArrayList;
import java.util.List;

public class RefactoringEngine {

    // Account data is kept private.
    static class BankAccount {

        private final String accountNumber;
        private String accountHolderName;
        private double balance;

        public static final double MINIMUM_BALANCE = 25.00;

        public BankAccount(String accountNumber,
                           String accountHolderName,
                           double balance) {

            if (accountNumber == null || accountNumber.isBlank()) {
                throw new IllegalArgumentException("Invalid account number");
            }

            if (accountHolderName == null || accountHolderName.isBlank()) {
                throw new IllegalArgumentException("Invalid account holder");
            }

            if (!Double.isFinite(balance) || balance < MINIMUM_BALANCE) {
                throw new IllegalArgumentException("Invalid initial balance");
            }

            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public double getBalance() {
            return balance;
        }

        public boolean deposit(double amount) {

            if (!Double.isFinite(amount) || amount <= 0) {
                return false;
            }

            balance += amount;
            return true;
        }

        public boolean withdraw(double amount) {

            if (!Double.isFinite(amount) || amount <= 0) {
                return false;
            }

            if (balance - amount < MINIMUM_BALANCE) {
                return false;
            }

            balance -= amount;
            return true;
        }

        public void displayAccount() {
            System.out.println(
                accountNumber + " | " +
                accountHolderName + " | $" + balance
            );
        }
    }

    // Account lookup is separated into its own method.
    public static BankAccount findAccount(
            List<BankAccount> accounts,
            String accountNumber) {

        if (accounts == null || accountNumber == null) {
            return null;
        }

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    // Transfer logic is separated from account management.
    public static boolean transfer(
            BankAccount src,
            BankAccount dest,
            double amount) {

        if (src == null || dest == null ||
            src == dest || !Double.isFinite(amount) ||
            amount <= 0) {

            return false;
        }

        if (!src.withdraw(amount)) {
            return false;
        }

        if (dest.deposit(amount)) {
            return true;
        }

        // Restore the source balance if deposit fails.
        src.deposit(amount);

        return false;
    }

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 =
            new BankAccount("ACC-101", "Abebe", 500.0);

        BankAccount acc2 =
            new BankAccount("ACC-102", "Kebede", 200.0);

        accounts.add(acc1);
        accounts.add(acc2);

        // Account lookup
        BankAccount found = findAccount(accounts, "ACC-101");

        if (found != null) {
            System.out.println("Account found:");
            found.displayAccount();
        }

        // Transfer
        boolean success = transfer(acc1, acc2, 150.0);

        System.out.println("Transfer Success: " + success);

        System.out.println("Final accounts:");
        acc1.displayAccount();
        acc2.displayAccount();

        System.out.println(
            "=== DAY 07 WEEKLY REFACTORING & CATCH-UP COMPLETED ==="
        );
    }
}
