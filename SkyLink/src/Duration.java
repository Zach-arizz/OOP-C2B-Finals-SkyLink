// FINALIZED
public record Duration(long totalMinutes) {
    public Duration {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("Total minutes cannot be negative.");
        }
    }

    public long getHours() {
        return totalMinutes / 60;
    }

    public long getRemainingMinutes() {
        return totalMinutes % 60;
    }

    public String toFormattedString() {
        long hours = getHours();
        long minutes = totalMinutes % 60;
        if (hours == 0) {
            return minutes + "m";
        }
        return hours + "h " + minutes + "m";
    }
}