public class CreditCard extends PaymentMethod {
    // Properties (Fields)
    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;
    private double availableLimit;

    // Constructor
    public CreditCard(String num, String name, String exp, String cvv, double limit) {
        super("CreditCard");

        if (num == null || num.trim().isEmpty() || num.length() < 12) {
            throw new IllegalArgumentException("Card number must be valid.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Card holder name cannot be null or empty.");
        }
        if (exp == null || exp.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry date cannot be null or empty.");
        }
        if (cvv == null || cvv.trim().isEmpty() || cvv.length() < 3) {
            throw new IllegalArgumentException("CVV must be valid.");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("Available limit cannot be negative.");
        }

        this.cardNumber = num.trim();
        this.cardHolderName = name.trim();
        this.expiryDate = exp.trim();
        this.cvv = cvv.trim();
        this.availableLimit = limit;
    }

    // Methods
    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            System.err.println("Cannot process non-positive payment amount.");
            return false;
        }

        if (validateCard()) {
            if (availableLimit >= amount) {
                // Deduct the amount from the available limit
                updateLimit(-amount);
                System.out.println("Paid " + amount + " with Credit Card. New limit: " + availableLimit);
                return true;
            } else {
                System.err.println("Payment failed: Insufficient available limit.");
                return false;
            }
        }
        System.err.println("Payment failed: Card validation failed.");
        return false;
    }

    public boolean validateCard() {
        System.out.println("Validating card...");
        return true;
    }

    public void updateLimit(double amount) {
        this.availableLimit += amount;
        if (this.availableLimit < 0) {
            this.availableLimit = 0;
        }
    }

    public String getCardInfo() {
        return "Card ending in " + cardNumber.substring(cardNumber.length() - 4);
    }

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public double getAvailableLimit() {
        return availableLimit;
    }
}