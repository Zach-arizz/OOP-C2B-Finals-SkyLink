import java.util.List;
import java.util.ArrayList;

public class Cabincrew extends Person {
    private String crewId;
    private Flight assignedFlight;
    private List<String> certifications;
    private List<String> languagesSpoken;
    private int yearsOfExperience;
    private boolean isInFlight;

    public Cabincrew(long id, String firstName, String lastName, String contactNumber, String email, String address, String crewId, Flight assignedFlight, int yearsOfExperience, boolean isInFlight) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.crewId = crewId;
        this.assignedFlight = assignedFlight;
        this.certifications = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
        this.yearsOfExperience = yearsOfExperience;
        this.isInFlight = isInFlight;
    }

    public void performPreflightSafetyChecks() {
        System.out.println("Performing Preflight Safety Checks...");
    }

    public void briefCrewOnEmergencyProcedures() {
        System.out.println("Briefing Crew on Emergency Procedures...");
    }

    public void attendToPassengerRequests(Passenger passenger, String request) {
        System.out.println("Attending to Passenger Requests: " + request);
    }

    public void monitorCabinEnvironment() {
        System.out.println("Monitoring Cabin Environment...");
    }

    public void logCabinIncidents(String incidentDetails) {
        System.out.println("Logging Cabin Incidents: " + incidentDetails);
    }

    public void assistInEvacuation(EmergencySystem emergency) {
        System.out.println("Assisting In Evacuation...");
    }

    public String getCrewId () {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public Flight getAssignedFlight () {
        return assignedFlight;
    }

    public void setAssignedFlight (Flight assignedFlight) {
        this.assignedFlight = assignedFlight;
    }

    public List<String> getCertifications () {
        return certifications;
    }

    public void addCertification(String certification) {
        this.certifications.add(certification);
    }

    public List<String> getLanguagesSpoken () {
        return languagesSpoken;
    }

    public void addLanguageSpoken(String language) {
        this.languagesSpoken.add(language);
    }

    public int getYearsOfExperience () {
        return yearsOfExperience;
    }

    public void setYearsOfExperience (int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public boolean isInFlight () {
        return isInFlight;
    }

    public void setInFlight (boolean InFlight) {
        this.isInFlight = InFlight;
    }
}