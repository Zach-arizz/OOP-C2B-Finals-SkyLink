import java.util.List;
import java.util.ArrayList;

public class FlightAttendant extends Person {
    private String employeeNumber;
    private List<String> certifications;
    private List<String> languagesSpoken;
    private int yearsOfExperience;
    private boolean isLeadOnFlight;
    private List<String> assignedDuties;

    public FlightAttendant (long id, String firstName, String lastName, String contactNumber, String email, String address, String employeeNumber, int yearsOfExperience) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.employeeNumber = employeeNumber;
        this.certifications = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
        this.yearsOfExperience = yearsOfExperience;
        this.isLeadOnFlight = false;
        this.assignedDuties = new ArrayList<>();
    }

    public void serveMeals(Passenger passenger) {
        System.out.println("Serving meals...");
    }

    public void assistPassenger(Passenger passenger, String request) {
        System.out.println("Assisting passenger...");
    }

    public void provideSafetyDemonstration() {
        System.out.println("Providing safety demonstration...");
    }

    public void handleEmergency(EmergencySystem emergency) {
        System.out.println("Handling emergency...");
    }

    public void manageCabinInventory() {
        System.out.println("Managing cabin inventory...");
    }

    public void reportIncident(String incidentDetails) {
        System.out.println("Reporting incident details...");
    }

    public void communicateWithCrew(String message) {
        System.out.println("Communicating with crew...");
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void addCertification(String certification) {
        this.certifications.add(certification);
    }

    public List<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void addLanguageSpoken(String language) {
        this.languagesSpoken.add(language);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public boolean isLeadOnFlight() {
        return isLeadOnFlight;
    }

    public void setLeadOnFlight(boolean leadOnFlight) {
        isLeadOnFlight = leadOnFlight;
    }

    public List<String> getAssignedDuties() {
        return assignedDuties;
    }

    public void addAssignedDuty(String duty) {
        this.assignedDuties.add(duty);
    }
}