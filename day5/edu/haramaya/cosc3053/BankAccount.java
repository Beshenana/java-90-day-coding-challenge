
package day5.edu.haramaya.cosc3053;

public class BankAccount {

    // TODO 1: Encapsulated fields
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public static final double MINIMUM_BALANCE = 25.00;

    // TODO 2: Constructor with validation
    public BankAccount(String accountNumber,
                       String accountHolderName,
                       double initialDeposit) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                "Account number cannot be empty."
            );
        }

        if (accountHolderName == null || accountHolderName.isBlank()) {
            throw new IllegalArgumentException(
                "Account holder name cannot be empty."
            );
        }

        if (!Double.isFinite(initialDeposit)
                || initialDeposit < MINIMUM_BALANCE) {
            throw new IllegalArgumentException(
                "Initial deposit must be at least $25.00."
            );
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // TODO 3: Deposit method
    public boolean deposit(double amount) {

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return false;
        }

        balance += amount;

        System.out.printf(
            "Deposited $%.2f into %s. New balance: $%.2f%n",
            amount, accountNumber, balance
        );

        return true;
    }

    // TODO 4: Withdrawal method
    public boolean withdraw(double amount) {

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return false;
        }

        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println(
                "Insufficient balance! Minimum balance must be $25.00."
            );
            return false;
        }

        balance -= amount;

        System.out.printf(
            "Withdrew $%.2f from %s. New balance: $%.2f%n",
            amount, accountNumber, balance
        );

        return true;
    }

    // TODO 5: Transfer method
    public boolean transferTo(BankAccount targetAccount, double amount) {

        if (targetAccount == null) {
            System.out.println("Transfer failed: Target account is null.");
            return false;
        }

        System.out.printf(
            "Transferring $%.2f from %s to %s...%n",
            amount, accountNumber, targetAccount.getAccountNumber()
        );

        if (!this.withdraw(amount)) {
            System.out.println("Transfer failed.");
            return false;
        }

        if (!targetAccount.deposit(amount)) {
            // Refund the source account if the target deposit fails.
            this.deposit(amount);
            System.out.println("Transfer failed. Money refunded.");
            return false;
        }

        System.out.println("Transfer completed successfully!");
        return true;
    }

    // TODO 6: Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Update account holder name safely
    public void setAccountHolderName(String accountHolderName) {

        if (accountHolderName == null || accountHolderName.isBlank()) {
            System.out.println("Invalid account holder name!");
            return;
        }

        this.accountHolderName = accountHolderName;
    }

    // TODO 7: Display account summary
    public void displayAccountSummary() {

        System.out.printf(
            "Account No: %-12s | Holder: %-15s | Balance: $%.2f%n",
            accountNumber,
            accountHolderName,
            balance
        );
    }
}
