// FINALIZED
import java.util.Date;

public class Refund {
    // Properties (Fields)
    private final String refundId;
    private final CancellationRequest originatingRequest;
    private final double amount;
    private final Date refundDate;
    private String paymentMethod;
    private RefundStatus status;

    // Constructor
    public Refund(CancellationRequest originatingRequest, double amount) {
        if (originatingRequest == null) {
            throw new IllegalArgumentException("Originating request cannot be null.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Refund amount must be positive.");
        }
        this.refundId = "REF-" + originatingRequest.getRequestId();
        this.originatingRequest = originatingRequest;
        this.amount = amount;
        this.refundDate = new Date();
        this.status = RefundStatus.PENDING;
    }

    // Methods
    public void executePayment() {
        if (this.paymentMethod == null || this.paymentMethod.trim().isEmpty()) {
            System.err.println("Cannot execute payment: Payment method has not been set.");
            return;
        }
        if (this.status == RefundStatus.COMPLETED) {
            System.out.println("Refund " + refundId + " is already completed.");
            return;
        }
        this.status = RefundStatus.COMPLETED;
        System.out.println("Refund " + refundId + " successfully executed for amount $" + amount + " via " + paymentMethod + ".");
    }

    public void updateStatus(RefundStatus newStatus) {
        if (newStatus == null) {
            System.err.println("Cannot update status to null.");
            return;
        }
        this.status = newStatus;
        System.out.println("Refund " + refundId + " status updated to: " + newStatus);
    }

    // Getters and Setters
    public String getRefundId() {
        return refundId;
    }

    public CancellationRequest getOriginatingRequest() {
        return originatingRequest;
    }

    public double getAmount() {
        return amount;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod != null && !paymentMethod.trim().isEmpty()) {
            this.paymentMethod = paymentMethod.trim();
        } else {
            System.err.println("Payment method cannot be null or empty.");
        }
    }

    public RefundStatus getStatus() {
        return status;
    }
}