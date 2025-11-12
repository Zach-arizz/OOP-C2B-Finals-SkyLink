public enum BookingStatus {
    PENDING,
    CONFIRMED,
    CHECKED_IN,
    CANCELLED,
    NOSHOW,
    FLOWN;

    public boolean isBooked() {
        return this == PENDING || this == CONFIRMED || this == CHECKED_IN;
    }

    public boolean isFinal() {
        return this == CANCELLED || this == NOSHOW || this == FLOWN;
    }
}