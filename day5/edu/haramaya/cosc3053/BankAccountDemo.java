
package day5.edu.haramaya.cosc3053;

public class BankAccountDemo {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       HARAMAYA BANK SYSTEM");
        System.out.println("========================================");

        // 1. Create two bank accounts
        System.out.println("\n--- 1. CREATING ACCOUNTS ---");

        BankAccount acc1 =
            new BankAccount("ACC-1001", "Abebe Bekele", 500.00);

        BankAccount acc2 =
            new BankAccount("ACC-1002", "Kebede Lemma", 200.00);

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();

        // 2. Valid transactions
        System.out.println("\n--- 2. VALID TRANSACTIONS ---");

        acc1.deposit(150.00);

        acc1.withdraw(100.00);

        acc1.transferTo(acc2, 75.00);

        // 3. Invalid operations
        System.out.println("\n--- 3. INVALID OPERATIONS ---");

        // Invalid account creation
        try {
            BankAccount badAccount =
                new BankAccount("ACC-1003", "Invalid User", 10.00);

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Expected exception: " + e.getMessage()
            );
        }

        // Negative deposit
        acc1.deposit(-50.00);

        // Withdrawal that violates minimum balance
        acc2.withdraw(260.00);

        // 4. Final account summaries
        System.out.println("\n--- 4. FINAL ACCOUNT SUMMARIES ---");

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();

        System.out.println("========================================");
        System.out.println("           PROGRAM FINISHED");
        System.out.println("========================================");
    }
}
