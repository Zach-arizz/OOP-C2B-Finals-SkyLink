public enum CancellationStatus {
    PENDING_APPROVAL,
    APPROVED,
    DENIED,
    REFUND_PROCESSING,
    COMPLETED;

    public boolean requiresRefund() {
        return this == APPROVED || this == REFUND_PROCESSING;
    }
}