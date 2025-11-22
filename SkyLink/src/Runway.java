// FINALIZED
public class Runway {
    // Properties (Fields)
    private final String runwayId;
    private double length;
    private RunwayStatus status;
    private boolean isInstrumentLandingSystemEnabled;

    private static final double MIN_LENGTH_FOR_LARGE_AIRCRAFT_M = 2900.0;
    private static final double LARGE_AIRCRAFT_WEIGHT_KG = 150000.0;

    // Constructor
    public Runway(String runwayId, double length) {
        if (runwayId == null || runwayId.trim().isEmpty()) {
            throw new IllegalArgumentException("Runway ID cannot be null or empty.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Runway length must be positive.");
        }
        this.runwayId = runwayId.trim();
        this.length = length;
        this.status = RunwayStatus.OPEN;
        this.isInstrumentLandingSystemEnabled = false;
    }

    // Methods
    public boolean authorizeTakeoff(Flight flight) {
        if (flight == null || flight.getAssignedAircraft() == null) {
            System.err.println("Takeoff denied: Flight or assigned aircraft is null.");
            return false;
        }

        if (this.status == RunwayStatus.OPEN && canSupportAircraft(flight.getAssignedAircraft())) {
            System.out.println("Takeoff authorized on Runway " + runwayId + " for " + flight.getFlightNumber());
            return true;
        }
        System.out.println("Takeoff denied on Runway " + runwayId + ". Status is " + this.status.name() + " or insufficient length.");
        return false;
    }

    public boolean authorizeLanding(Flight flight) {
        if (flight == null || flight.getAssignedAircraft() == null) {
            System.err.println("Landing denied: Flight or assigned aircraft is null.");
            return false;
        }

        if (this.status == RunwayStatus.OPEN && canSupportAircraft(flight.getAssignedAircraft())) {
            System.out.println("Landing authorized on Runway " + runwayId + " for " + flight.getFlightNumber());
            return true;
        }
        System.out.println("Landing denied on Runway " + runwayId + ". Status is " + this.status.name() + " or insufficient length.");
        return false;
    }

    public void closeRunway(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            reason = "Unspecified reason";
        }
        this.status = RunwayStatus.CLOSED;
        System.out.println("Runway " + runwayId + " closed. Reason: " + reason.trim());
    }

    public void openRunway() {
        this.status = RunwayStatus.OPEN;
        System.out.println("Runway " + runwayId + " is now OPEN.");
    }

    public void inspectSurface() {
        this.status = RunwayStatus.MAINTENANCE;
        System.out.println("Runway " + runwayId + " is undergoing surface inspection.");
    }

    public boolean canSupportAircraft(Aircraft aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot check support: Aircraft object is null.");
            return false;
        }
        if (aircraft.getWeight() > LARGE_AIRCRAFT_WEIGHT_KG && this.length < MIN_LENGTH_FOR_LARGE_AIRCRAFT_M) {
            System.out.println("Runway " + runwayId + " too short (" + this.length + "m) for this heavy aircraft.");
            return false;
        }
        return true;
    }

    // Getters and Setters
    public String getRunwayId() {
        return runwayId;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.err.println("Runway length must be positive.");
        }
    }

    public RunwayStatus getStatus() {
        return status;
    }

    public void setStatus(RunwayStatus status) {
        if (status != null) {
            this.status = status;
        } else {
            System.err.println("Status cannot be set to null.");
        }
    }

    public boolean isInstrumentLandingSystemEnabled() {
        return isInstrumentLandingSystemEnabled;
    }

    public void setInstrumentLandingSystemEnabled(boolean isInstrumentLandingSystemEnabled) {
        this.isInstrumentLandingSystemEnabled = isInstrumentLandingSystemEnabled;
    }
}