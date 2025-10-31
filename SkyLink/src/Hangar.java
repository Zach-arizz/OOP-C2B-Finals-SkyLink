import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class MaintenanceRecord {}

public class Hangar {
    private String hangarId;
    private List<Aircraft> storedAircraft;
    private boolean maintenanceCrewAvailable;
    private List<String> equipment;
    private String assignedArea;

    public Hangar(String hangarId, boolean maintenanceCrewAvailable, String assignedArea) {
        this.hangarId = hangarId;
        this.storedAircraft = new ArrayList<>();
        this.maintenanceCrewAvailable = maintenanceCrewAvailable;
        this.equipment = new ArrayList<>();
        this.assignedArea = assignedArea;
    }

    public void storeAircraft(Aircraft aircraft) {
        this.storedAircraft.add(aircraft);
    }

    public void performMaintenance(Aircraft aircraft, MaintenanceRecord record) {
    }

    public void removeAircraft(Aircraft aircraft) {
        this.storedAircraft.remove(aircraft);
    }

    public void scheduleRepair(Aircraft aircraft, Date date) {
    }

    public void checkEquipmentStatus() {
    }

    public List<Aircraft> getStoredAircraft() {
        return storedAircraft;
    }

    public String getHangarId() {
        return hangarId;
    }

    public boolean isMaintenanceCrewAvailable() {
        return maintenanceCrewAvailable;
    }

    public void setMaintenanceCrewAvailable(boolean maintenanceCrewAvailable) {
        this.maintenanceCrewAvailable = maintenanceCrewAvailable;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }
}