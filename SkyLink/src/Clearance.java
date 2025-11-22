// FINALIZED
import java.util.Date;

public record Clearance(String clearanceId, String aircraftIdentifier, String instruction, String validityArea, Date issueTime, Double assignedAltitudeFeet, Date expirationTime) {
    public boolean isValid() {
        if (expirationTime == null) {
            return true;
        }
        return new Date().before(expirationTime);
    }
}