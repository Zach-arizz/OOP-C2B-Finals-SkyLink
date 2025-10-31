public enum RefundStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED;

    public boolean isFinal() {
        return this == COMPLETED || this == FAILED || this == CANCELLED;
    }
}