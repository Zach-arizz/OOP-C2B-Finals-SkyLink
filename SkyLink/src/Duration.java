public record Duration(long totalMinutes) {
    public Duration(long totalMinutes) {
        this.totalMinutes = Math.max(0, totalMinutes);
    }

    public long getHours() {
        return totalMinutes / 60;
    }

    public long getRemainingMinutes() {
        return totalMinutes % 60;
    }

    public String toFormattedString() {
        long hours = getHours();
        long minutes = getRemainingMinutes();
        if (hours == 0) {
            return minutes + "m";
        }
        return hours + "h " + minutes + "m";
    }
}
