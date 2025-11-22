// FINALIZED
public class PassportControl {
    // Properties (Fields)
    private final String checkpointId;

    // Constructor
    public PassportControl(String checkpointId) {
        if (checkpointId == null || checkpointId.trim().isEmpty()) {
            throw new IllegalArgumentException("Checkpoint ID cannot be null or empty.");
        }

        this.checkpointId = checkpointId.trim();
    }

    // Methods
    public boolean verifyPassport(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot verify null passenger.");
            return false;
        }
        System.out.println("Verifying passport: " + passenger.getPassportNumber());
        return true;
    }

    public boolean checkVisaRequirements(Passenger passenger, Flight flight) {
        if (passenger == null || flight == null) {
            System.err.println("Cannot check visa: Passenger or Flight is null.");
            return false;
        }
        System.out.println("Checking visa for destination...");
        return true;
    }

    public void flagPassenger(Passenger passenger, String reason) {
        if (passenger == null || reason == null || reason.trim().isEmpty()) {
            System.err.println("Cannot flag passenger: Input invalid.");
            return;
        }
        System.out.println("Passenger " + passenger.getFullName() + " flagged: " + reason.trim());
    }

    public void approveEntry(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot approve entry for null passenger.");
            return;
        }
        System.out.println("Entry approved for " + passenger.getFullName());
    }

    public void denyEntry(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot deny entry for null passenger.");
            return;
        }
        System.out.println("Entry denied for " + passenger.getFullName());
    }

    // Getters and Setters
    public String getCheckpointId() {
        return checkpointId;
    }
}