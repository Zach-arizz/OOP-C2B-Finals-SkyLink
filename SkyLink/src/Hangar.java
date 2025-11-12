import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.stream.Collectors;

public class Hangar {
    // Properties (Fields)
    private final String hangarId;
    private List<Aircraft> storedAircraft;
    private boolean maintenanceCrewAvailable;
    private List<String> equipment;
    private String assignedArea;

    // Constructor
    public Hangar(String hangarId, String assignedArea) {
        if (hangarId == null || hangarId.trim().isEmpty() || assignedArea == null || assignedArea.trim().isEmpty()) {
            throw new IllegalArgumentException("Hangar ID and assigned area cannot be null or empty.");
        }
        this.hangarId = hangarId.trim();
        this.assignedArea = assignedArea.trim();
        this.storedAircraft = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.maintenanceCrewAvailable = false;
    }

    // Methods
    public boolean storeAircraft(Aircraft aircraft) {
        if (aircraft != null) {
            this.storedAircraft.add(aircraft);
            System.out.println("Aircraft " + aircraft.getAircraftId() + " stored in Hangar " + this.hangarId);
            return true;
        }
        System.err.println("Cannot store a null aircraft.");
        return false;
    }

    public void performMaintenance(Aircraft aircraft, MaintenanceRecord record) {
        if (aircraft == null || record == null) {
            throw new IllegalArgumentException("Aircraft and MaintenanceRecord must not be null.");
        }
        if (this.maintenanceCrewAvailable && this.storedAircraft.contains(aircraft)) {
            System.out.println("Starting maintenance on " + aircraft.getAircraftId() + ". Record ID: " + record.getRecordId());
        } else {
            throw new IllegalStateException("Cannot perform maintenance: Crew unavailable or aircraft not in hangar.");
        }
    }

    public boolean removeAircraft(Aircraft aircraft) {
        if (aircraft != null && this.storedAircraft.remove(aircraft)) {
            System.out.println("Aircraft " + aircraft.getAircraftId() + " removed from Hangar " + this.hangarId);
            return true;
        }
        if (aircraft != null) {
            System.err.println("Aircraft " + aircraft.getAircraftId() + " is not currently stored in Hangar " + this.hangarId + ".");
        }
        return false;
    }

    public void scheduleRepair(Aircraft aircraft, Date date) {
        if (aircraft == null || date == null) {
            System.err.println("Cannot schedule repair: Aircraft or date is null.");
            return;
        }
        System.out.println("Repair scheduled for " + aircraft.getAircraftId() + " on " + date.toString());
    }

    public void checkEquipmentStatus() {
        if (this.equipment.isEmpty()) {
            System.out.println("Equipment Check: No equipment registered for Hangar " + this.hangarId + ".");
            return;
        }
        String status = this.equipment.stream().collect(Collectors.joining(", ", "Equipment Check: ", " all operational."));
        System.out.println(status);
    }

    // Getters and Setters
    public String getHangarId() {
        return hangarId;
    }

    public List<Aircraft> getStoredAircraft() {
        return Collections.unmodifiableList(storedAircraft);
    }

    public void setStoredAircraft(List<Aircraft> storedAircraft) {
        if (storedAircraft != null) {
            this.storedAircraft = storedAircraft;
        } else {
            System.err.println("Cannot set stored aircraft list to null.");
        }
    }

    public boolean isMaintenanceCrewAvailable() {
        return maintenanceCrewAvailable;
    }

    public void setMaintenanceCrewAvailable(boolean maintenanceCrewAvailable) {
        this.maintenanceCrewAvailable = maintenanceCrewAvailable;
    }

    public List<String> getEquipment() {
        return Collections.unmodifiableList(equipment);
    }

    public void setEquipment(List<String> equipment) {
        if (equipment != null) {
            this.equipment = equipment;
        } else {
            System.err.println("Cannot set equipment list to null.");
        }
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        if (assignedArea != null && !assignedArea.trim().isEmpty()) {
            this.assignedArea = assignedArea.trim();
        } else {
            System.err.println("Assigned area cannot be set to null or empty.");
        }
    }
}