import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Aircraft {
    // Properties (Fields)
    private final String aircraftId;
    private final String model;
    private final int seatCapacity;
    private AircraftStatus status;
    private final List<Engine> engines;
    private NavigationSystem navigationSystem;
    private FuelSystem fuelSystem;
    private final List<MaintenanceRecord> maintenanceHistory;
    private final double BASE_EMPTY_WEIGHT_KG;

    // Constructor
    public Aircraft(String aircraftId, String model, int seatCapacity, NavigationSystem navigationSystem, FuelSystem fuelSystem) {
        if (aircraftId == null || aircraftId.trim().isEmpty()) {
            throw new IllegalArgumentException("Aircraft ID cannot be null or empty.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (seatCapacity <= 0) {
            throw new IllegalArgumentException("Seat capacity must be a positive number.");
        }
        if (navigationSystem == null) {
            System.err.println("Warning: NavigationSystem is null.");
        }
        if (fuelSystem == null) {
            System.err.println("Warning: FuelSystem is null.");
        }

        this.aircraftId = aircraftId.trim();
        this.model = model.trim();
        this.seatCapacity = seatCapacity;
        this.status = AircraftStatus.IN_MAINTENANCE;
        this.engines = new ArrayList<>();
        this.navigationSystem = navigationSystem;
        this.fuelSystem = fuelSystem;
        this.maintenanceHistory = new ArrayList<>();
        this.BASE_EMPTY_WEIGHT_KG = 280000.0;
    }

    // Methods
    public boolean assignToFlight(Flight flight) {
        if (flight == null) {
            System.err.println("Cannot assign aircraft to a null flight.");
            return false;
        }
        if (checkFlightReadiness()) {
            System.out.println("Aircraft " + aircraftId + " assigned to flight " + flight.getFlightNumber());
            this.status = AircraftStatus.PARKED;
            return true;
        }
        System.out.println("Aircraft " + aircraftId + " cannot be assigned. Status: " + this.status);
        return false;
    }

    public void updateStatus(AircraftStatus status) {
        if (status == null) {
            System.err.println("Cannot update status to null.");
            return;
        }
        System.out.println("Aircraft " + aircraftId + " status changed from " + this.status + " to " + status);
        this.status = status;
    }

    public void performPreFlightInspection() {
        System.out.println("\n--- Performing pre-flight inspection for " + aircraftId + " ---");

        if (fuelSystem == null) {
            System.err.println("PRE-FLIGHT FAILED: Fuel system is missing.");
            this.status = AircraftStatus.IN_MAINTENANCE;
            return;
        }

        if (!fuelSystem.verifyFuelQuality()) {
            System.err.println("PRE-FLIGHT FAILED: Fuel quality is not nominal.");
            this.status = AircraftStatus.IN_MAINTENANCE;
            return;
        }

        if (engines.isEmpty()) {
            System.err.println("PRE-FLIGHT FAILED: No engines mounted.");
            this.status = AircraftStatus.IN_MAINTENANCE;
            return;
        }

        for (Engine engine : engines) {
            engine.checkMaintenanceRequirement();
            if (engine.getStatus() == EngineStatus.MAINTENANCE_REQUIRED) {
                System.err.println("PRE-FLIGHT FAILED: Engine " + engine.getEngineId() + " requires maintenance.");
                this.status = AircraftStatus.IN_MAINTENANCE;
                return;
            }
        }

        if (navigationSystem == null) {
            System.err.println("PRE-FLIGHT FAILED: Navigation system is missing.");
            this.status = AircraftStatus.IN_MAINTENANCE;
            return;
        }
        System.out.println("Pre-flight successful. Setting status to READY.");
        this.status = AircraftStatus.READY;
    }

    public void runEngineDiagnostics() {
        if (this.engines.isEmpty()) {
            System.err.println("Cannot run diagnostics: No engines mounted.");
            return;
        }
        System.out.println("Running diagnostics on " + this.engines.size() + " engine(s).");
        for (Engine engine : engines) {
            engine.runEngineCheck();
        }
    }

    public void recordMaintenance(MaintenanceRecord record) {
        if (record != null) {
            this.maintenanceHistory.add(record);
            System.out.println("Maintenance record " + record.getRecordId() + " added.");
        } else {
            System.err.println("Cannot record a null maintenance record.");
        }
    }

    public boolean checkFlightReadiness() {
        return this.status == AircraftStatus.READY &&
                this.navigationSystem != null &&
                this.fuelSystem != null &&
                !this.engines.isEmpty();
    }

    public double getWeight() {
        return BASE_EMPTY_WEIGHT_KG;
    }


    // Getters and Setters
    public String getAircraftId() {
        return aircraftId;
    }

    public String getModel() {
        return model;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public AircraftStatus getStatus() {
        return status;
    }

    public List<Engine> getEngines() {
        return Collections.unmodifiableList(engines);
    }

    public void addEngine(Engine engine) {
        if (engine != null) {
            this.engines.add(engine);
            System.out.println("Engine " + engine.getEngineId() + " mounted on aircraft " + aircraftId);
        } else {
            System.err.println("Attempted to add a null engine to aircraft " + aircraftId);
        }
    }

    public void removeEngine(Engine engine) {
        if (engine == null) {
            System.err.println("Cannot remove a null engine.");
            return;
        }
        if (this.engines.remove(engine)) {
            System.out.println("Engine " + engine.getEngineId() + " removed from aircraft " + aircraftId);
        } else {
            System.out.println("Engine " + engine.getEngineId() + " was not found on aircraft " + aircraftId);
        }
    }

    public NavigationSystem getNavigationSystem() {
        return navigationSystem;
    }

    public void setNavigationSystem(NavigationSystem navigationSystem) {
        if (navigationSystem != null) {
            this.navigationSystem = navigationSystem;
        } else {
            System.err.println("Cannot set NavigationSystem to null.");
        }
    }

    public FuelSystem getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(FuelSystem fuelSystem) {
        if (fuelSystem != null) {
            this.fuelSystem = fuelSystem;
        } else {
            System.err.println("Cannot set FuelSystem to null.");
        }
    }

    public List<MaintenanceRecord> getMaintenanceHistory() {
        return Collections.unmodifiableList(maintenanceHistory);
    }
}