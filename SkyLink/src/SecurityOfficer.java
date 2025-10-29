import java.util.List;
import java.util.ArrayList;

class SecurityScanResult {}
class Document {}
class CargoHold {}

public class SecurityOfficer extends Person {

    private String officerId;
    private String assignedCheckpoint;
    private List<String> certifications;
    private ShiftSchedule shiftSchedule;
    private boolean isOnDuty;

    public SecurityOfficer(long id, String firstName, String lastName, String contactNumber, String email, String address, String officerId, String assignedCheckpoint, ShiftSchedule shiftSchedule) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.officerId = officerId;
        this.assignedCheckpoint = assignedCheckpoint;
        this.shiftSchedule = shiftSchedule;
        this.certifications = new ArrayList<>();
        this.isOnDuty = true;
    }

    public SecurityScanResult performPassengerScreening(Passenger passenger, Baggage baggage) {
        System.out.println("Performing Passenger Screening...");
        return new SecurityScanResult();
    }

    public boolean verifyIdentity(Document passportOrID) {
        System.out.println("Verifying Identity...");
        return true;
    }

    public void escalateSecurityAlert(String alertLevel, String details) {
        System.out.println("Escalating Security Alert...");
    }

    public void inspectCargo (CargoHold cargo) {
        System.out.println("Inspecting Cargo...");
    }

    public void recordSecurityLog(String logEntry) {
        System.out.println("Recording Security Log...");
    }

    public void coordinateWithLawEnforcement(String situationDetails) {
        System.out.println("Coordinating with Law Enforcement...");
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getAssignedCheckpoint() {
        return assignedCheckpoint;
    }

    public void setAssignedCheckpoint(String assignedCheckpoint) {
        this.assignedCheckpoint = assignedCheckpoint;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void addCertification(String certification) {
        certifications.add(certification);
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(ShiftSchedule shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }
}