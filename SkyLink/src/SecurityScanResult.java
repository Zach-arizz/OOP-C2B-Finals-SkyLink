// FINALIZED
import java.util.Date;
import java.util.List;

public record SecurityScanResult(String scanId, boolean isClear, String reasonForFlag, List<String> detectedItems, String officerId, Date scanTimestamp) {
    public String getSummary() {
        if (isClear) {
            return String.format("Scan ID %s: CLEARED at %s.", scanId, scanTimestamp);
        } else {
            return String.format("Scan ID %s: FLAGGED. Reason: %s.", scanId, reasonForFlag);
        }
    }
}
