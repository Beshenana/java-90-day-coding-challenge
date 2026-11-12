
package edu.haramaya.cosc3053.Day8;

public class PaymentGatewayDemo {

    // 1. Interface: defines the payment contract
    public interface Payable {

        boolean processPayment(double amount);

        String getReceipt();

        // Default method
        default void logTrace(double amount) {
            System.out.println("[AUDIT] Processing payment: $" + amount);
        }
    }

    // 2. Abstract class: provides shared data and behavior
    public static abstract class AbstractGateway implements Payable {

        private final String merchantId;

        public AbstractGateway(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public abstract double calculateFee(double amount);
    }

    // 3. Concrete class: extends the abstract class
    public static class CreditCardGateway extends AbstractGateway {

        private double lastPayment;
        private double lastFee;
        private boolean paymentSuccessful;

        public CreditCardGateway(String merchantId) {
            super(merchantId);
        }

        // TODO 8.2: Calculate a 2.5% payment fee
        @Override
        public double calculateFee(double amount) {

            if (amount <= 0) {
                return 0;
            }

            return amount * 0.025;
        }

        // TODO 8.3: Process the payment
        @Override
        public boolean processPayment(double amount) {

            if (amount <= 0 || !Double.isFinite(amount)) {
                paymentSuccessful = false;
                return false;
            }

            logTrace(amount);

            lastPayment = amount;
            lastFee = calculateFee(amount);
            paymentSuccessful = true;

            return true;
        }

        // Generate the payment receipt
        @Override
        public String getReceipt() {

            if (!paymentSuccessful) {
                return "No successful payment found.";
            }

            return "Merchant ID: " + getMerchantId()
                    + "\nPayment Amount: $" + lastPayment
                    + "\nPayment Fee: $" + lastFee
                    + "\nTotal Amount: $" + (lastPayment + lastFee);
        }
    }

    // 4. Main method
    public static void main(String[] args) {

        System.out.println(
                "Day 08 Interfaces & Abstract Classes Challenge"
        );

        // Create a credit card payment gateway
        CreditCardGateway gateway =
                new CreditCardGateway("HARAMAYA-001");

        // Process payment
        boolean result = gateway.processPayment(1000.00);

        // Display payment result
        System.out.println("Payment Successful: " + result);

        // Display calculated fee
        System.out.println("Payment Fee: $" +
                gateway.calculateFee(1000.00));

        // Display receipt
        System.out.println("\n--- PAYMENT RECEIPT ---");
        System.out.println(gateway.getReceipt());
    }
}
