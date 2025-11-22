// FINALIZED
public class DebitCard extends PaymentMethod {
    // Properties (Fields)
    private final String accountNumber;
    private final String bankName;
    private double balance;

    // Constructor
    public DebitCard(String accNum, String bankName, double balance) {
        super("DebitCard");

        if (accNum == null || accNum.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (bankName == null || bankName.trim().isEmpty()) {
            throw new IllegalArgumentException("Bank name cannot be null or empty.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accNum.trim();
        this.bankName = bankName.trim();
        this.balance = balance;
    }

    // Methods
    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            System.err.println("Cannot process non-positive payment amount.");
            return false;
        }

        if (validateAccount()) {
            if (balance >= amount) {
                deductAmount(amount);
                System.out.println("Paid " + amount + " with Debit Card. Remaining balance: " + balance);
                return true;
            } else {
                System.err.println("Payment failed: Insufficient balance in account " + accountNumber + ".");
                return false;
            }
        }
        System.err.println("Payment failed: Account validation failed.");
        return false;
    }

    public boolean validateAccount() {
        System.out.println("Validating debit account...");
        return true;
    }

    public void deductAmount(double amount) {
        if (amount <= 0) {
            System.err.println("Cannot deduct non-positive amount.");
            return;
        }
        this.balance -= amount;
    }

    public void addAmount(double amount) {
        if (amount <= 0) {
            System.err.println("Cannot add non-positive amount.");
            return;
        }
        this.balance += amount;
        System.out.println("Balance credited by " + amount + ".");
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.err.println("Balance cannot be set to a negative value.");
            return;
        }
        this.balance = balance;
    }
}