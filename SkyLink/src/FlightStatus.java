// FINALIZED
public enum FlightStatus {
    SCHEDULED,
    BOARDING,
    DEPARTED,
    IN_FLIGHT,
    DELAYED,
    ARRIVED,
    CANCELLED,
    DIVERTED;

    public boolean isActive() {
        return switch (this) {
            case SCHEDULED, BOARDING, DEPARTED, IN_FLIGHT, DELAYED -> true;
            default -> false;
        };
    }

    public boolean isFinalStatus() {
        return switch (this) {
            case ARRIVED, CANCELLED, DIVERTED -> true;
            default -> false;
        };
    }
}
