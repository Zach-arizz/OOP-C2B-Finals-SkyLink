import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SecurityCheck {
    // Properties (Fields)
    private final String checkpointId;
    private List<SecurityOfficer> officers;
    private boolean bodyScannerAvailable;
    private boolean luggageScannerAvailable;

    // Constructor
    public SecurityCheck(String checkpointId) {
        if (checkpointId == null || checkpointId.trim().isEmpty()) {
            throw new IllegalArgumentException("Checkpoint ID cannot be null or empty.");
        }

        this.checkpointId = checkpointId.trim();
        this.officers = new ArrayList<>();
        this.bodyScannerAvailable = true;
        this.luggageScannerAvailable = true;
    }

    // Methods
    public boolean screenPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot screen a null passenger.");
            return false;
        }

        if (bodyScannerAvailable) {
            System.out.println("Screening passenger " + passenger.getId() + " at " + checkpointId + ". Result: Cleared.");
            return true;
        }
        System.out.println("Body scanner unavailable at " + checkpointId + ".");
        return false;
    }

    public boolean scanBaggage(Baggage baggage) {
        if (baggage == null) {
            System.err.println("Cannot scan null baggage.");
            return false;
        }

        if (luggageScannerAvailable) {
            String tagNum = (baggage.getTag() != null) ? baggage.getTag().getTagNumber() : "UNTAGGED";
            System.out.println("Scanning baggage " + tagNum + " at " + checkpointId + ". Result: Cleared.");
            return true;
        }
        System.out.println("Luggage scanner unavailable at " + checkpointId + ".");
        return false;
    }

    public void enforceSecurityProtocol(int threatLevel) {
        if (threatLevel < 1) {
            System.err.println("Threat level must be positive.");
            return;
        }
        System.out.println("Security protocol escalated to Level " + threatLevel + " at " + checkpointId);
    }

    public void detainPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot detain null passenger.");
            return;
        }
        System.out.println("Passenger " + passenger.getId() + " detained at checkpoint " + checkpointId);
    }

    public void logSecurityIncident(String details) {
        if (details == null || details.trim().isEmpty()) {
            System.err.println("Incident details cannot be empty.");
            return;
        }
        System.out.println("Security incident logged at " + checkpointId + ": " + details);
    }

    // Getters and Setters
    public String getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(String checkpointId) {
        if (checkpointId == null || checkpointId.trim().isEmpty()) {
            System.err.println("Checkpoint ID cannot be set to null or empty.");
            return;
        }
    }

    public List<SecurityOfficer> getOfficers() {
        return Collections.unmodifiableList(officers);
    }

    public void setOfficers(List<SecurityOfficer> officers) {
        if (officers == null) {
            this.officers = new ArrayList<>();
            return;
        }
        this.officers = new ArrayList<>(officers);
    }

    public boolean isBodyScannerAvailable() {
        return bodyScannerAvailable;
    }

    public void setBodyScannerAvailable(boolean bodyScannerAvailable) {
        this.bodyScannerAvailable = bodyScannerAvailable;
    }

    public boolean isLuggageScannerAvailable() {
        return luggageScannerAvailable;
    }

    public void setLuggageScannerAvailable(boolean luggageScannerAvailable) {
        this.luggageScannerAvailable = luggageScannerAvailable;
    }
}