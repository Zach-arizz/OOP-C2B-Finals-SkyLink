// FINALIZED
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class FlightAttendant extends Person {
    // Properties (Fields)
    private final List<String> certifications;
    private final List<String> languagesSpoken;
    private int yearsOfExperience;
    private boolean isLeadOnFlight;
    private final List<String> assignedDuties;

    // Constructor
    public FlightAttendant(long id, String firstName, String lastName, String contactNumber, String email, String address,
                           int yearsOfExperience) {
        super(id, firstName, lastName, contactNumber, email, address);
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative.");
        }
        this.yearsOfExperience = yearsOfExperience;
        this.certifications = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
        this.assignedDuties = new ArrayList<>();
        this.isLeadOnFlight = false;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Flight Attendant (Exp: " + this.yearsOfExperience + " yrs, ID: " + this.getId() + ")";
    }

    public void declareFlightEmergency(EmergencySystem emergency, EmergencyType type, String details) {
        if (emergency != null && type != null && details != null && !details.trim().isEmpty()) {
            emergency.declareEmergency(type, getLastName() + " report: " + details);
        } else {
            System.err.println("Cannot declare emergency: Invalid EmergencySystem, Type, or details provided.");
        }
    }

    public void logEmergencyAction(EmergencySystem emergency, String actionDescription) {
        if (emergency != null && emergency.isEmergencyDeclared() && actionDescription != null && !actionDescription.trim().isEmpty()) {
            EmergencyResponseAction action = new EmergencyResponseAction(
                    getLastName() + " (FA)",
                    actionDescription,
                    new Date()
            );
            emergency.logAction(action);
        } else {
            System.out.println(getLastName() + " tried to log an action, but no active emergency or action description is missing.");
        }
    }

    public void serveMeals(Passenger passenger) {
        if (passenger != null) {
            System.out.println("Serving meal to passenger " + passenger.getLastName() + ".");
        } else {
            System.err.println("Cannot serve meal to a null passenger.");
        }
    }

    public void assistPassenger(Passenger passenger, String request) {
        if (passenger != null && request != null && !request.trim().isEmpty()) {
            System.out.println("Assisting passenger " + passenger.getLastName() + " with request: " + request + ".");
        } else {
            System.err.println("Cannot assist passenger: Passenger is null or request is empty.");
        }
    }

    public void provideSafetyDemonstration() {
        System.out.println("Providing mandatory safety demonstration.");
    }

    public void handleEmergency(EmergencySystem emergency) {
        if (emergency != null && emergency.isEmergencyDeclared()) {
            logEmergencyAction(emergency, "Directing passengers to nearest exit/safety position.");
            System.out.println("Handling emergency procedures.");
        } else {
            System.out.println("Cannot execute emergency handling: No active emergency declared.");
        }
    }

    public void manageCabinInventory() {
        System.out.println("Managing cabin inventory and supplies.");
    }

    public void reportIncident(String incidentDetails) {
        if (incidentDetails != null && !incidentDetails.trim().isEmpty()) {
            System.out.println("Reporting cabin incident: " + incidentDetails);
        } else {
            System.err.println("Incident report details cannot be empty.");
        }
    }

    public void communicateWithCrew(String message) {
        if (message != null && !message.trim().isEmpty()) {
            System.out.println("Communicating with Flight Crew: " + message);
        } else {
            System.err.println("Communication message cannot be empty.");
        }
    }

    public void addCertification(String certification) {
        if (certification != null && !certification.trim().isEmpty()) {
            this.certifications.add(certification.trim());
        }
    }

    public void addLanguage(String language) {
        if (language != null && !language.trim().isEmpty()) {
            this.languagesSpoken.add(language.trim());
        }
    }

    public void incrementYearsOfExperience(int years) {
        if (years > 0) {
            this.yearsOfExperience += years;
        } else {
            System.err.println("Cannot increment years of experience by a non-positive amount.");
        }
    }

    public void assignDuty(String duty) {
        if (duty != null && !duty.trim().isEmpty()) {
            this.assignedDuties.add(duty.trim());
        }
    }

    // Getters and Setters
    public List<String> getCertifications() {
        return Collections.unmodifiableList(certifications);
    }

    public List<String> getLanguagesSpoken() {
        return Collections.unmodifiableList(languagesSpoken);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public boolean isLeadOnFlight() {
        return isLeadOnFlight;
    }

    public void setLeadOnFlight(boolean isLeadOnFlight) {
        this.isLeadOnFlight = isLeadOnFlight;
    }

    public List<String> getAssignedDuties() {
        return Collections.unmodifiableList(assignedDuties);
    }
}