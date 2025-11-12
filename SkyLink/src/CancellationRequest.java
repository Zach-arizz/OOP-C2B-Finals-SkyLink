import java.util.Date;

public class CancellationRequest {
    // Properties (Fields)
    private final String requestId;
    private final Booking booking;
    private String reason;
    private CancellationStatus status;
    private final Date requestDate;

    // Constructor
    public CancellationRequest(String requestId, Booking booking, String reason) {
        this.requestId = requestId;
        this.booking = booking;
        this.reason = reason;
        this.status = CancellationStatus.PENDING_APPROVAL;
        this.requestDate = new Date();
    }

    // Methods
    public Refund processRefund() {
        if (this.status.requiresRefund()) {
            this.status = CancellationStatus.REFUND_PROCESSING;
            double refundAmount = this.booking.getTotalPrice() * 0.90; //10% Cancellation Fee
            Refund refund = new Refund(this, refundAmount);
            System.out.println("Initiating refund for request " + this.requestId + ". Amount: $" + refundAmount);
            return refund;
        } else {
            System.out.println("No refund required for current status: " + this.status);
            return null;
        }
    }

    public void updateStatus(CancellationStatus newStatus) {
        this.status = newStatus;
        System.out.println("Cancellation request " + this.requestId + " status updated to: " + newStatus);
    }

    public String getCancellationSummary() {
        return String.format("Request ID: %s, Booking: %s, Status: %s, Reason: %s",
                this.requestId,
                this.booking.getBookingId(),
                this.status,
                this.reason);
    }

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public Booking getBooking() {
        return booking;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CancellationStatus getStatus() {
        return status;
    }

    public Date getRequestDate() {
        return requestDate;
    }
}