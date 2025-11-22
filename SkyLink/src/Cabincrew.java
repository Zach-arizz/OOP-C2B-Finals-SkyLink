// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Cabincrew extends Person {
    // Properties (Fields)
    private Flight assignedFlight;
    private final List<String> certifications;
    private final List<String> languagesSpoken;
    private int yearsOfExperience;
    private boolean isInflight;

    // Constructor
    public Cabincrew(long id, String firstName, String lastName, String contactNumber, String email, String address,
                     int yearsOfExperience) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.yearsOfExperience = yearsOfExperience;
        this.certifications = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
        this.isInflight = false;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Cabin Crew (ID: " + this.getId() + ", Experience: " + this.yearsOfExperience + " yrs)";
    }

    public void performPreflightSafetyChecks() {
        System.out.println(getLastName() + " is performing safety checks.");
    }

    public void briefCrewOnEmergencyProcedures() {
        System.out.println(getLastName() + " is briefing the crew.");
    }

    public void attendToPassengerRequests(Passenger passenger, String request) {
        System.out.println("Attending to Passenger " + passenger.getLastName() + "'s request: " + request);
    }

    public void monitorCabinEnvironment() {
        System.out.println(getLastName() + " is monitoring the cabin environment.");
    }

    public void assistInEvacuation(EmergencySystem emergency) {
        logEmergencyAction(emergency, "Initiating passenger bracing and evacuation procedures.");
        System.out.println(getLastName() + " is assisting with evacuation procedures.");
    }

    public void declareFlightEmergency(EmergencySystem emergency, EmergencyType type, String details) {
        if (emergency != null) {
            emergency.declareEmergency(type, getLastName() + " report: " + details);
        } else {
            System.err.println("Cannot declare emergency: No EmergencySystem instance available.");
        }
    }

    public void logEmergencyAction(EmergencySystem emergency, String actionDescription) {
        if (emergency != null && emergency.isEmergencyDeclared()) {
            EmergencyResponseAction action = new EmergencyResponseAction(
                    getLastName() + " (Crew)",
                    actionDescription,
                    new Date()
            );
            emergency.logAction(action);
        } else {
            System.out.println(getLastName() + " tried to log an action, but no emergency is active.");
        }
    }

    public void logCabinIncidents(String incidentDetails) {
        System.out.println("Logging incident: " + incidentDetails);
    }

    // Getters and Setters
    public Flight getAssignedFlight() {
        return assignedFlight;
    }
    public void setAssignedFlight(Flight assignedFlight) {
        this.assignedFlight = assignedFlight;
    }

    public List<String> getCertifications() {
        return Collections.unmodifiableList(certifications);
    }

    public void addCertification(String certification) {
        this.certifications.add(certification);
    }

    public List<String> getLanguagesSpoken() {
        return Collections.unmodifiableList(languagesSpoken);
    }

    public void addLanguage(String language) {
        this.languagesSpoken.add(language);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void incrementYearsOfExperience(int years) {
        if (years > 0) {
            this.yearsOfExperience += years;
        }
    }

    public boolean isInflight() {
        return isInflight;
    }

    public void setInflight(boolean isInflight) {
        this.isInflight = isInflight;
    }
}