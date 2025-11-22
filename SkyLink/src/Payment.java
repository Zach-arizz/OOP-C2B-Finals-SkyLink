// FINALIZED
import java.util.Date;

public class Payment {
    // Properties (Fields)
    private final String paymentId;
    private final Booking booking;
    private final double amount;
    private final Date paymentDate;
    private PaymentStatus status;
    private Transaction transaction;

    // Constructor
    public Payment(String paymentId, Booking booking, double amount) {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment ID cannot be null or empty.");
        }
        if (booking == null) {
            throw new IllegalArgumentException("Booking must be provided.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }

        this.paymentId = paymentId.trim();
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = new Date(); // Set upon creation
        // NOTE: Assuming PaymentStatus enum exists
        this.status = PaymentStatus.PENDING;
        this.transaction = null;
    }

    // Methods
    public boolean processPayment(PaymentMethod method) {
        if (method == null) {
            System.err.println("Cannot process payment: Payment method is null.");
            return false;
        }
        boolean success = method.pay(this.amount);

        if (success) {
            this.status = PaymentStatus.COMPLETED;
            System.out.println("Payment " + paymentId + " successfully COMPLETED.");
        } else {
            this.status = PaymentStatus.FAILED;
            System.err.println("Payment " + paymentId + " FAILED.");
        }

        this.transaction = generateTransactionRecord();
        return success;
    }

    public void updateStatus(PaymentStatus status) {
        if (status == null) {
            System.err.println("Cannot update status to null.");
            return;
        }
        this.status = status;
        System.out.println("Payment " + paymentId + " status updated to: " + status);
    }

    public Transaction generateTransactionRecord() {
        TransactionStatus txStatus = (this.status == PaymentStatus.COMPLETED || this.status == PaymentStatus.REFUNDED) ?
                TransactionStatus.SUCCESS : TransactionStatus.FAILED;
        return new Transaction("TX" + paymentId, this.amount, txStatus);
    }

    public boolean verifyPayment() {
        return this.status == PaymentStatus.COMPLETED;
    }

    public String paymentSummary() {
        return "Payment " + paymentId + ": " + amount + " [" + status + "]";
    }

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.updateStatus(status);
    }

    public Transaction getTransaction() {
        return transaction;
    }
}