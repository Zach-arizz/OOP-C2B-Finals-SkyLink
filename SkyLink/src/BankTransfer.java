public class BankTransfer extends PaymentMethod {
    // Properties (Fields)
    private final String bankName;
    private final String accountNumber;
    private final String swiftCode;

    // Constructor
    public BankTransfer(String bankName, String accNum, String swift) {
        super("BankTransfer");

        if (bankName == null || bankName.trim().isEmpty()) {
            throw new IllegalArgumentException("Bank name cannot be null or empty.");
        }
        if (accNum == null || accNum.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (swift == null || swift.trim().isEmpty()) {
            throw new IllegalArgumentException("SWIFT code cannot be null or empty.");
        }
        this.bankName = bankName.trim();
        this.accountNumber = accNum.trim();
        this.swiftCode = swift.trim();
    }

    // Methods
    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            System.err.println("Cannot process non-positive payment amount.");
            return false;
        }
        requestTransferAuthorization();
        confirmTransfer();

        System.out.println("Paid " + amount + " via Bank Transfer from " + bankName + ".");
        return true;
    }

    public void requestTransferAuthorization() {
        if (!isAuthorized()) {
            System.out.println("Requesting bank transfer auth for " + accountNumber + "...");
            authorizePayment();
        } else {
            System.out.println("Transfer already authorized.");
        }
    }

    public void confirmTransfer() {
        System.out.println("Bank transfer confirmed (SWIFT: " + swiftCode + ").");
    }

    // Getters and Setters
    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSwiftCode() {
        return swiftCode;
    }
}