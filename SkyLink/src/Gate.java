import java.util.List;
import java.util.ArrayList;

enum GateStatus {
    AVAILABLE,
    OCCUPIED,
    CLOSED,
    BOARDING
}

public class Gate {
    private String gateNumber;
    private GateStatus status;
    private Flight currentFlight;
    private boolean hasJetBridge;

    public Gate(String gateNumber, boolean hasJetBridge) {
        this.gateNumber = gateNumber;
        this.status = GateStatus.AVAILABLE;
        this.currentFlight = null;
        this.hasJetBridge = hasJetBridge;
    }

    public void openGate() {
        this.status = GateStatus.AVAILABLE;
    }

    public void closeGate() {
        this.status = GateStatus.CLOSED;
        this.currentFlight = null;
    }

    public void startBoarding(Flight flight) {
        this.status = GateStatus.BOARDING;
        this.currentFlight = flight;
    }

    public void endBoarding() {
        this.status = GateStatus.AVAILABLE;
        this.currentFlight = null;
    }

    public boolean isAvailable() {
        return this.status == GateStatus.AVAILABLE;
    }

    public void displayFlightInfo() {
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public GateStatus getStatus() {
        return status;
    }

    public Flight getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(Flight currentFlight) {
        this.currentFlight = currentFlight;
        if (currentFlight != null && this.status == GateStatus.AVAILABLE) {
            this.status = GateStatus.OCCUPIED;
        }
    }

    public boolean isHasJetBridge() {
        return hasJetBridge;
    }

    public void setHasJetBridge(boolean hasJetBridge) {
        this.hasJetBridge = hasJetBridge;
    }
}