import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class SecurityOfficer extends Person {
    // Properties (Fields)
    private String assignedCheckpoint;
    private final List<String> certifications;
    private ShiftSchedule shiftSchedule;
    private boolean isOnDuty;

    // Constructor
    public SecurityOfficer(long id, String firstName, String lastName, String contactNumber, String email, String address,
                           String assignedCheckpoint) {
        super(id, firstName, lastName, contactNumber, email, address);

        if (assignedCheckpoint == null || assignedCheckpoint.trim().isEmpty()) {
            throw new IllegalArgumentException("Assigned checkpoint cannot be null or empty.");
        }

        this.assignedCheckpoint = assignedCheckpoint.trim();
        this.certifications = new ArrayList<>();
        this.isOnDuty = false;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Security Officer (Checkpoint: " + this.assignedCheckpoint + ", ID: " + this.getId() + ")";
    }

    public SecurityScanResult performPassengerScreening(Passenger passenger, Baggage baggage) {
        if (passenger == null || baggage == null) {
            System.err.println("Cannot perform screening with null passenger or baggage.");
            return new SecurityScanResult("SCRN-FAIL-" + new Date().getTime(), false, "Null input provided.", List.of(), String.valueOf(this.getId()), new Date());
        }

        System.out.println("Screening Passenger ID " + passenger.getId() + " and baggage at checkpoint " + this.assignedCheckpoint + ".");

        boolean isClear = Math.random() > 0.1;
        List<String> detected = isClear ? List.of() : List.of("Liquid > 100ml");
        String reason = isClear ? "N/A" : "Prohibited item detected.";

        SecurityScanResult result = new SecurityScanResult(
                "SCRN-" + passenger.getId() + "-" + new Date().getTime(),
                isClear,
                reason,
                detected,
                String.valueOf(this.getId()),
                new Date()
        );

        this.recordSecurityLog(result.getSummary());
        return result;
    }

    public boolean verifyIdentity(Document passportOrID) {
        if (passportOrID == null) {
            System.out.println("Verification FAILED: Document is null.");
            return false;
        }

        System.out.println("Verifying identity using provided " + passportOrID.getDocumentType() + ".");

        if (passportOrID.isExpired()) {
            System.out.println("Verification FAILED: Document is expired.");
            return false;
        }

        passportOrID.setVerified(true);
        passportOrID.setVerificationOfficerId(String.valueOf(this.getId()));

        System.out.println("Verification successful for holder: " + passportOrID.getHolderName() + ".");
        return true;
    }

    public void escalateSecurityAlert(String alertLevel, String details) {
        if (alertLevel == null || alertLevel.trim().isEmpty() || details == null || details.trim().isEmpty()) {
            System.err.println("Cannot escalate alert with null or empty details.");
            return;
        }

        System.out.println("ESCALATING ALERT (" + alertLevel + ") from officer " + this.getId() + ": " + details);
        this.recordSecurityLog("ESCALATION: " + alertLevel + " - " + details);
    }

    public void inspectCargo(CargoHold cargo) {
        if (cargo == null) {
            System.err.println("Cannot inspect null cargo hold.");
            return;
        }

        System.out.println("Officer " + this.getId() + " is inspecting cargo hold for prohibited items.");

        boolean passed = cargo.inspectContents(String.valueOf(this.getId()));

        if (passed) {
            this.recordSecurityLog("CargoHold inspection passed.");
        } else {
            this.recordSecurityLog("CargoHold inspection FAILED. Escalating.");
            this.escalateSecurityAlert("LEVEL 3 (Cargo Failure)", "Prohibited items found during cargo inspection.");
        }
    }

    public void recordSecurityLog(String logEntry) {
        if (logEntry == null || logEntry.trim().isEmpty()) {
            return;
        }
        System.out.println("[" + new Date() + "] Log recorded by " + this.getId() + ": " + logEntry);
    }

    public void coordinateWithLawEnforcement(String situationDetails) {
        if (situationDetails == null || situationDetails.trim().isEmpty()) {
            System.err.println("Cannot coordinate with empty situation details.");
            return;
        }

        System.out.println("Officer " + this.getId() + " coordinating with law enforcement: " + situationDetails);
        this.recordSecurityLog("LE COORDINATION: " + situationDetails);
    }

    public void addCertification(String certification) {
        if (certification != null && !certification.trim().isEmpty() && !this.certifications.contains(certification.trim())) {
            this.certifications.add(certification.trim());
        }
    }

    public void removeCertification(String certification) {
        if (certification != null) {
            this.certifications.remove(certification.trim());
        }
    }

    // Getters and Setters
    public String getAssignedCheckpoint() {
        return assignedCheckpoint;
    }

    public void setAssignedCheckpoint(String assignedCheckpoint) {
        if (assignedCheckpoint == null || assignedCheckpoint.trim().isEmpty()) {
            System.err.println("Assigned checkpoint cannot be set to null or empty.");
            return;
        }
        this.assignedCheckpoint = assignedCheckpoint.trim();
    }

    public List<String> getCertifications() {
        return Collections.unmodifiableList(certifications);
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

    public void setOnDuty(boolean isOnDuty) {
        this.isOnDuty = isOnDuty;
    }
}