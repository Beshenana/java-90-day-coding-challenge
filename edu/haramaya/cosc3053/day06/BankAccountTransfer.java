package edu.haramaya.cosc3053.day06;

import day5.edu.haramaya.cosc3053.BankAccount;

public class BankAccountTransfer {

    public static boolean transfer(
            BankAccount src,
            BankAccount dest,
            double amount) {

        // Step 1: Validate the inputs
        if (src == null || dest == null || src == dest || amount <= 0.0) {
            return false;
        }

        // Step 2: Withdraw money from the source account
        if (!src.withdraw(amount)) {
            return false;
        }

        // Step 3: Deposit money into the destination account
        if (dest.deposit(amount)) {
            return true;
        }

        // Step 4: Rollback if the deposit fails
        src.deposit(amount);

        return false;
    }

    public static void main(String[] args) {

        BankAccount acc1 =
                new BankAccount("ACC-101", "Abebe", 500.0);

        BankAccount acc2 =
                new BankAccount("ACC-102", "Kebede", 200.0);

        boolean success = transfer(acc1, acc2, 150.0);

        System.out.println("Transfer Success: " + success);
        System.out.println("ACC-101 Balance: $" + acc1.getBalance());
        System.out.println("ACC-102 Balance: $" + acc2.getBalance());
    }
}