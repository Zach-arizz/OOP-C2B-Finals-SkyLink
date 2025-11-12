import java.time.LocalDateTime;

public class ParkingBay {
    // Properties(Fields)
    private final String bayId;
    private BayStatus status;
    private Aircraft parkedAircraft;
    private String zone;

    // Constructor
    public ParkingBay(String bayId, String zone) {
        this.bayId = bayId;
        this.zone = zone;
        this.status = BayStatus.AVAILABLE;
        this.parkedAircraft = null;
    }

    // Methods
    public boolean parkAircraft(Aircraft aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot park a null aircraft.");
            return false;
        }
        if (this.status == BayStatus.AVAILABLE) {
            this.parkedAircraft = aircraft;
            this.status = BayStatus.OCCUPIED;
            logParkingDetails();
            System.out.println("Aircraft " + aircraft.getAircraftId() + " parked at Bay " + bayId);
            return true;
        }
        System.out.println("Cannot park aircraft: Bay " + bayId + " is currently " + this.status.name());
        return false;
    }

    public void releaseAircraft() {
        if (this.parkedAircraft != null) {
            String aircraftId = this.parkedAircraft.getAircraftId();
            System.out.println("Aircraft " + aircraftId + " released from Bay " + bayId);
            this.parkedAircraft = null;
            this.status = BayStatus.CLEANUP;
            logParkingDetails();
            this.status = BayStatus.AVAILABLE;
        } else {
            System.out.println("No aircraft to release from Bay " + bayId);
        }
    }

    public boolean isAvailable() {
        return this.status == BayStatus.AVAILABLE && this.parkedAircraft == null;
    }

    public void updateStatus(BayStatus status) {
        if (status == null) {
            System.err.println("Cannot update status to null.");
            return;
        }
        this.status = status;
        System.out.println("Parking Bay " + bayId + " status updated to " + status.name());
    }

    public void logParkingDetails() {
        String aircraftId = (parkedAircraft != null) ? parkedAircraft.getAircraftId() : "NONE";
        System.out.println("[" + LocalDateTime.now() + "] Bay " + bayId + " status: " + status.name() + ", Aircraft: " + aircraftId);
    }

    // Getters and Setters
    public String getBayId() {
        return bayId;
    }

    public BayStatus getStatus() {
        return status;
    }

    public void setStatus(BayStatus status) {
        if (status != null) {
            this.status = status;
        } else {
            System.err.println("Cannot set status to null.");
        }
    }

    public Aircraft getParkedAircraft() {
        return parkedAircraft;
    }

    public void setParkedAircraft(Aircraft parkedAircraft) {
        this.parkedAircraft = parkedAircraft;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        if (zone != null && !zone.trim().isEmpty()) {
            this.zone = zone.trim();
        } else {
            System.err.println("Zone cannot be set to null or empty.");
        }
    }
}