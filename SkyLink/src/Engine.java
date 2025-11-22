// FINALIZED
import java.util.List;
import java.util.ArrayList;

public class Engine {
    // Properties (Fields)
    private final String engineId;
    private final String engineModel;
    private final double thrust;
    private EngineStatus status;
    private double hoursOperated;

    // Constructor
    public Engine(String engineId, String engineModel, double thrust) {
        if (engineId == null || engineId.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine ID cannot be null or empty.");
        }
        if (engineModel == null || engineModel.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine model cannot be null or empty.");
        }
        if (thrust <= 0) {
            throw new IllegalArgumentException("Maximum thrust must be a positive value.");
        }

        this.engineId = engineId.trim();
        this.engineModel = engineModel.trim();
        this.thrust = thrust;
        this.status = EngineStatus.OFF;
        this.hoursOperated = 0.0;
    }

    // Methods
    public void startEngine() {
        if (this.status == EngineStatus.OFF) {
            this.status = EngineStatus.IDLE;
            System.out.println("Engine " + engineId + " started and is now " + this.status);
        } else if (this.status == EngineStatus.MAINTENANCE_REQUIRED) {
            System.err.println("Engine " + engineId + " cannot start: Maintenance is required.");
        } else {
            System.out.println("Engine " + engineId + " is already running (" + this.status + ").");
        }
    }

    public void shutdownEngine() {
        this.status = EngineStatus.OFF;
        System.out.println("Engine " + engineId + " is OFF.");
    }

    public void runEngineCheck() {
        System.out.println("Running diagnostic check on Engine " + engineId + "...");
    }

    public void logOperatingHours(double hours) {
        if (hours > 0) {
            this.hoursOperated += hours;
            System.out.println(hours + " hours logged. Total: " + this.hoursOperated);
            checkMaintenanceRequirement();
        } else {
            System.err.println("Cannot log zero or negative hours.");
        }
    }

    public void checkMaintenanceRequirement() {
        if (this.hoursOperated >= 1000.0 && this.hoursOperated % 1000.0 < 100.0) {
            if (this.status != EngineStatus.MAINTENANCE_REQUIRED) {
                this.status = EngineStatus.MAINTENANCE_REQUIRED;
                System.err.println("!!! Engine " + engineId + " needs maintenance soon (over " + this.hoursOperated + " hours).");
            }
        }
    }

    public void setLowPower() {
        if (this.status == EngineStatus.IDLE || this.status == EngineStatus.RUNNING_HIGH) {
            this.status = EngineStatus.RUNNING_LOW;
            System.out.println("Engine " + engineId + " set to LOW POWER.");
        } else if (this.status == EngineStatus.OFF || this.status == EngineStatus.MAINTENANCE_REQUIRED) {
            System.err.println("Cannot set power: Engine " + engineId + " is " + this.status);
        }
    }

    public void setHighPower() {
        if (this.status == EngineStatus.RUNNING_LOW || this.status == EngineStatus.IDLE) {
            this.status = EngineStatus.RUNNING_HIGH;
            System.out.println("Engine " + engineId + " set to HIGH POWER.");
        } else if (this.status == EngineStatus.OFF || this.status == EngineStatus.MAINTENANCE_REQUIRED) {
            System.err.println("Cannot set power: Engine " + engineId + " is " + this.status);
        }
    }

    // Getters
    public String getEngineId() {
        return engineId;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public double getThrust() {
        return thrust;
    }

    public EngineStatus getStatus() {
        return status;
    }

    public double getHoursOperated() {
        return hoursOperated;
    }
}