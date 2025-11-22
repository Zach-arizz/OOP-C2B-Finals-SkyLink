// FINALIZED
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GroundCrew extends Person {
    // Properties (Fields)
    private String assignedArea;
    private final List<String> certifiedEquipment;
    private final List<String> responsibilities;
    private boolean isAvailable;

    // Constructor
    public GroundCrew(long id, String firstName, String lastName,
                      String contactNumber, String email, String address,
                      String assignedArea) {
        super(id, firstName, lastName, contactNumber, email, address);
        if (assignedArea == null || assignedArea.trim().isEmpty()) {
            throw new IllegalArgumentException("Assigned area cannot be null or empty.");
        }
        this.assignedArea = assignedArea.trim();
        this.certifiedEquipment = new ArrayList<>();
        this.responsibilities = new ArrayList<>();
        this.isAvailable = true;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Ground Crew (Area: " + this.assignedArea + ", ID: " + this.getId() + ")";
    }

    public void marshalAircraft(Aircraft aircraft, Runway runway) {
        if (aircraft == null || runway == null) {
            System.err.println("Cannot marshal: Aircraft or Runway is null.");
            return;
        }
        System.out.println("Marshalling " + aircraft.getAircraftId() + " to Runway " + runway.getRunwayId() + ".");
        this.isAvailable = false;
    }

    public void loadBaggage(Aircraft aircraft, List<Baggage> baggageList) {
        if (aircraft == null || baggageList == null) {
            System.err.println("Cannot load baggage: Aircraft or baggage list is null.");
            return;
        }
        System.out.println("Loading " + baggageList.size() + " bags onto Aircraft " + aircraft.getAircraftId() + ".");
        this.isAvailable = false;
    }

    public void performGroundService(Aircraft aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot perform ground service: Aircraft is null.");
            return;
        }
        System.out.println("Performing ground service on Aircraft " + aircraft.getAircraftId() + " (fuel, catering, etc.).");
        this.isAvailable = false;
    }

    public boolean inspectGroundEquipment(String equipmentId) {
        if (equipmentId == null || equipmentId.trim().isEmpty()) {
            System.err.println("Cannot inspect equipment: ID is empty.");
            return false;
        }
        System.out.println("Inspecting equipment: " + equipmentId + ".");
        return true;
    }

    public void reportGroundIncident(String details) {
        if (details == null || details.trim().isEmpty()) {
            System.err.println("Cannot report incident: Details are empty.");
            return;
        }
        System.out.println("Ground Incident Reported: " + details);
    }

    public void coordinateWithRampControl(AirTrafficController atc) {
        if (atc == null) {
            System.err.println("Cannot coordinate: AirTrafficController is null.");
            return;
        }
        System.out.println("Coordinating ramp movement with ATC.");
        this.isAvailable = false;
    }

    public void addCertifiedEquipment(String equipment) {
        if (equipment != null && !equipment.trim().isEmpty()) {
            this.certifiedEquipment.add(equipment.trim());
        }
    }

    public void addResponsibility(String responsibility) {
        if (responsibility != null && !responsibility.trim().isEmpty()) {
            this.responsibilities.add(responsibility.trim());
        }
    }

    // Getters and Setters
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

    public List<String> getCertifiedEquipment() {
        return Collections.unmodifiableList(certifiedEquipment);
    }

    public List<String> getResponsibilities() {
        return Collections.unmodifiableList(responsibilities);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        if (isAvailable) {
            System.out.println(this.getLastName() + " is now available.");
        } else {
            System.out.println(this.getLastName() + " is now busy.");
        }
    }
}