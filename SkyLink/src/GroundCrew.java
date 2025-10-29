import java.util.List;
import java.util.ArrayList;

class Baggage {}

public class GroundCrew extends Person {
    private String crewId;
    private String assignedArea;
    private List<String> certifiedEquipment;
    private List<String> responsibilities;
    private boolean isAvailable;

    public GroundCrew(long id, String firstName, String lastName, String contactNumber, String email, String address, String crewId, String assignedArea) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.crewId = crewId;
        this.assignedArea = assignedArea;
        this.certifiedEquipment = new ArrayList<>();
        this.responsibilities = new ArrayList<>();
        this.isAvailable = true;
    }

    public void marshalAircraft(Aircraft aircraft, Runway runway) {
        System.out.println("Marshaling Aircraft...");
    }

    public void loadBaggage(Aircraft aircraft, List<Baggage> baggageList) {
        System.out.println("Loading Baggage...");
    }

    public void performGroundService(Aircraft aircraft) {
        System.out.println("Performing Ground Service...");
    }

    public boolean inspectGroundEquipment(String equipmentId) {
        System.out.println("Inspecting Ground Equipment...");
        return true;
    }

    public void reportGroundIncident(String details) {
        System.out.println("Reporting Ground Incident...");
    }

    public void coordinateWithRampControl(AirTrafficControl atc) {
        System.out.println("Coordinating with Ramp Control...");
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }

    public List<String> getCertifiedEquipment() {
        return certifiedEquipment;
    }

    public void addCertifiedEquipment(String equipment) {
        this.certifiedEquipment.add(equipment);
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void addResponsibility(String responsibility) {
        this.responsibilities.add(responsibility);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}