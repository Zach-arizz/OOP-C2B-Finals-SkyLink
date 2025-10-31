import java.util.List;
import java.util.ArrayList;

enum BayStatus {
    AVAILABLE,
    OCCUPIED,
    CLOSED
}

public class ParkingBay {
    private String bayId;
    private BayStatus status;
    private Aircraft parkedAircraft;
    private String zone;

    public ParkingBay(String bayId, String zone) {
        this.bayId = bayId;
        this.zone = zone;
        this.status = BayStatus.AVAILABLE;
        this.parkedAircraft = null;
    }

    public boolean parkAircraft(Aircraft aircraft) {
        if (this.status.equals(BayStatus.AVAILABLE)) {
            this.parkedAircraft = aircraft;
            this.status = BayStatus.OCCUPIED;
            return true;
        }
        return false;
    }

    public void releaseAircraft() {
        this.parkedAircraft = null;
        this.status = BayStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return this.status.equals(BayStatus.AVAILABLE);
    }

    public void updateStatus(BayStatus status) {
        this.status = status;
        if (status == BayStatus.CLOSED) {
            this.parkedAircraft = null;
        }
    }

    public void logParkingDetails() {
    }

    public String getBayId() {
        return bayId;
    }

    public BayStatus getStatus() {
        return status;
    }

    public Aircraft getParkedAircraft() {
        return parkedAircraft;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}