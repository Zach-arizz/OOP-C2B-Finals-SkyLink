public class Gate {
    // Properties (Fields)
    private final String gateNumber;
    private GateStatus status;
    private Flight currentFlight;
    private boolean hasJetBridge;

    // Constructor
    public Gate(String gateNumber, boolean hasJetBridge) {
        if (gateNumber == null || gateNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Gate number cannot be null or empty.");
        }
        this.gateNumber = gateNumber.trim();
        this.hasJetBridge = hasJetBridge;
        this.status = GateStatus.AVAILABLE;
    }

    // Methods
    public void openGate() {
        if (this.currentFlight != null) {
            throw new IllegalStateException("Cannot open gate; Flight " + currentFlight.getFlightNumber() + " is currently assigned.");
        }
        this.status = GateStatus.AVAILABLE;
        System.out.println("Gate " + this.gateNumber + " is now open and available.");
    }

    public void closeGate() {
        this.status = GateStatus.CLOSED;
        this.currentFlight = null;
        System.out.println("Gate " + this.gateNumber + " is closed.");
    }

    public void startBoarding(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Cannot start boarding with a null flight.");
        }
        if (this.currentFlight != flight) {
            throw new IllegalArgumentException("Cannot start boarding: Flight mismatch or no flight assigned to this gate.");
        }
        this.status = GateStatus.BOARDING;
        System.out.println("Boarding started for Flight " + flight.getFlightNumber() + " at Gate " + this.gateNumber + ".");
    }

    public void endBoarding() {
        if (this.status == GateStatus.BOARDING) {
            this.status = GateStatus.OCCUPIED;
            System.out.println("Boarding ended at Gate " + this.gateNumber + ".");
        }
    }

    public boolean isAvailable() {
        return this.status == GateStatus.AVAILABLE && this.currentFlight == null;
    }

    public void displayFlightInfo() {
        if (currentFlight != null) {
            System.out.println("Display: Flight " + currentFlight.getFlightNumber() + " is " + this.status.name());
        } else {
            System.out.println("Display: Gate " + this.gateNumber + " is " + this.status.name());
        }
    }

    // Getters and Setters
    public String getGateNumber() {
        return gateNumber;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        if (status != null) {
            this.status = status;
        } else {
            System.err.println("Cannot set gate status to null.");
        }
    }

    public Flight getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(Flight currentFlight) {
        this.currentFlight = currentFlight;
        if (currentFlight != null && this.status == GateStatus.AVAILABLE) {
            this.status = GateStatus.OCCUPIED;
        } else if (currentFlight == null) {
            this.status = GateStatus.CLOSED;
        }
    }

    public boolean isHasJetBridge() {
        return hasJetBridge;
    }

    public void setHasJetBridge(boolean hasJetBridge) {
        this.hasJetBridge = hasJetBridge;
    }
}