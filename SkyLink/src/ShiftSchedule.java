// FINALIZED
import java.time.LocalTime;

public class ShiftSchedule {
    // Properties (Fields)
    private final String scheduleId;
    private String shiftName;
    private LocalTime startTime;
    private LocalTime endTime;

    // Constructor
    public ShiftSchedule(String scheduleId, String shiftName, LocalTime startTime, LocalTime endTime) {
        if (scheduleId == null || scheduleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Schedule ID cannot be null or empty.");
        }
        if (shiftName == null || shiftName.trim().isEmpty()) {
            throw new IllegalArgumentException("Shift name cannot be null or empty.");
        }
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start time and end time must not be null.");
        }

        this.scheduleId = scheduleId.trim();
        this.shiftName = shiftName.trim();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Methods
    public boolean isDuringShift(LocalTime time) {
        if (time == null) {
            System.err.println("Cannot check shift status with null time.");
            return false;
        }

        if (startTime.equals(endTime)) {
            return false;
        }

        if (startTime.isBefore(endTime)) {
            // Day shift (09:00 to 17:00)
            return !time.isBefore(startTime) && time.isBefore(endTime);
        } else {
            // Night shift (22:00 to 06:00)
            return !time.isBefore(startTime) || time.isBefore(endTime);
        }
    }

    // Getters and Setters
    public String getScheduleId() {
        return scheduleId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setShiftName(String shiftName) {
        if (shiftName == null || shiftName.trim().isEmpty()) {
            System.err.println("Shift name cannot be set to null or empty.");
            return;
        }
        this.shiftName = shiftName.trim();
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime == null) {
            System.err.println("Start time cannot be set to null.");
            return;
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (endTime == null) {
            System.err.println("End time cannot be set to null.");
            return;
        }
        this.endTime = endTime;
    }
}