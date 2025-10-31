import java.util.Date;
import java.util.List;

public record EmergencyReport(String reportId, Date reportDate, String flightIdentifier, String emergencyType, long durationMinutes, List<EmergencyResponseAction> actionsTaken, String outcomeSummary) {
    public String getSummary() {
        return String.format("Report %s for Flight %s. Type: %s. Duration: %d min.",
                reportId, flightIdentifier, emergencyType, durationMinutes);
    }
}
