import java.util.List;
import java.util.ArrayList;

public class SecurityCheck {
    private String checkpointId;
    private List<SecurityOfficer>  securityOfficers;
    private boolean bodyScannerAvailable;
    private boolean luggageScannerAvailable;

    public  SecurityCheck(String checkpointId, boolean bodyScannerAvailable, boolean luggageScannerAvailable) {
        this.checkpointId = checkpointId;
        this.securityOfficers = new ArrayList<>();
        this.bodyScannerAvailable = bodyScannerAvailable;
        this.luggageScannerAvailable = luggageScannerAvailable;
    }

    public boolean screenPassenger(Passenger passenger) {
        return this.bodyScannerAvailable;
    }

    public boolean scanBaggage(Baggage baggage) {
        return this.luggageScannerAvailable;
    }

    public void enforceSecurityProtocol(int threatLevel) {
        System.out.println("Enforcing security protocol...");
    }

    public void detainPassenger(Passenger passenger) {
        System.out.println("Detainting security protocol...");
    }

    public void logSecurityIncident(String details) {
        System.out.println("Logging security incident...");
    }

    public String getCheckpointId() {
        return checkpointId;
    }

    public List<SecurityOfficer> getSecurityOfficers() {
        return securityOfficers;
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