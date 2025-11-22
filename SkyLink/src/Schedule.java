// FINALIZED
import java.util.Date;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class Schedule {
    // Properties (Fields)
    private Date departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Duration duration;
    private boolean delayed;
    private String delayReason;

    // Constructor
    public Schedule(Date departureDate, LocalTime departureTime, LocalTime arrivalTime) {
        if (departureDate == null || departureTime == null || arrivalTime == null) {
            throw new IllegalArgumentException("Departure date, departure time, and arrival time must not be null.");
        }

        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.delayed = false;
        this.duration = calculateDuration(departureTime, arrivalTime);
    }

    // Methods
    private Duration calculateDuration(LocalTime start, LocalTime end) {
        if (start != null && end != null) {
            long minutes = ChronoUnit.MINUTES.between(start, end);
            minutes = Math.max(0, minutes);
            return Duration.ofMinutes(minutes);
        }
        return Duration.ofMinutes(0);
    }

    public void updateDeparture(Date date, LocalTime time) {
        if (date == null || time == null) {
            System.err.println("Cannot update departure with null date or time.");
            return;
        }

        this.departureDate = date;
        this.departureTime = time;
        this.delayed = true;
        this.delayReason = "Manual update";
        this.duration = calculateDuration(time, this.arrivalTime);
    }

    public void markDelayed(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            reason = "Reason unknown";
        }
        this.delayed = true;
        this.delayReason = reason;
    }

    public boolean isOnSchedule() {
        return !this.delayed;
    }

    public void adjustArrivalTime(LocalTime newArrivalTime) {
        if (newArrivalTime == null) {
            System.err.println("Cannot adjust arrival time to null.");
            return;
        }
        this.arrivalTime = newArrivalTime;
        this.duration = calculateDuration(this.departureTime, this.arrivalTime);
    }

    // Getters and Setters
    public Date getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public String getDelayReason() {
        return delayReason;
    }
}