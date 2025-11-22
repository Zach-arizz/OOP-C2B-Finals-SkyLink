// FINALIZED
import java.util.Date;

public class Transaction {
    // Properties (Fields)
    private final String transactionId;
    private final Date timestamp;
    private final double amount;
    private TransactionStatus status;
    private String paymentReference;

    // Constructor
    public Transaction(String transactionId, double amount, TransactionStatus status) {
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or empty.");
        }
        if (amount <= 0) {
            System.out.println("Warning: Transaction amount is not positive. Setting status to FAILED.");
            this.status = TransactionStatus.FAILED;
        } else if (status == null) {
            throw new IllegalArgumentException("Transaction status must be provided.");
        } else {
            this.status = status;
        }

        this.transactionId = transactionId.trim();
        this.amount = amount;
        this.timestamp = new Date();
        this.paymentReference = null;
    }

    // Methods
    public boolean isSuccessful() {
        return this.status == TransactionStatus.SUCCESS;
    }

    public String summarize() {
        return String.format("TX ID: %s, Amount: %.2f, Status: %s, Time: %s",
                transactionId, amount, status, timestamp);
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        if (status == null) {
            System.err.println("Cannot set transaction status to null.");
            return;
        }
        this.status = status;
        System.out.println("Transaction " + transactionId + " status updated to " + status);
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        if (paymentReference != null) {
            this.paymentReference = paymentReference.trim();
        }
    }
}