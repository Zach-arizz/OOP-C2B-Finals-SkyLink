import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Pilot extends Person {
    // Properties (Fields)
    private final String licenseNumber;
    private double totalFlightHours;
    private final List<String> ratings;
    private final List<FlightLog> flightLogs;
    private MedicalCertificate medicalCertificate;
    private boolean isOnDuty;

    // Constructor
    public Pilot(long id, String firstName, String lastName, String contactNumber, String email, String address,
                 String licenseNumber, double totalFlightHours) {
        super(id, firstName, lastName, contactNumber, email, address);
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be null or empty.");
        }
        if (totalFlightHours < 0) {
            throw new IllegalArgumentException("Total flight hours cannot be negative.");
        }
        this.licenseNumber = licenseNumber.trim();
        this.totalFlightHours = totalFlightHours;
        this.ratings = new ArrayList<>();
        this.flightLogs = new ArrayList<>();
        this.isOnDuty = false;
        this.medicalCertificate = null;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Pilot (License: " + this.licenseNumber + ", Hours: " + this.totalFlightHours + ")";
    }

    public void declareFlightEmergency(EmergencySystem emergency, EmergencyType type, String details) {
        if (emergency == null || type == null || details == null || details.trim().isEmpty()) {
            System.err.println("Cannot declare emergency: System, type, or details are invalid.");
            return;
        }
        emergency.declareEmergency(type, "Pilot " + getLastName() + " declaration: " + details.trim());
        emergency.coordinateWithATCForPriority(null, type.name() + " PRIORITY");
    }

    public void logEmergencyAction(EmergencySystem emergency, String actionDescription) {
        if (emergency == null || actionDescription == null || actionDescription.trim().isEmpty()) {
            System.err.println("Cannot log action: EmergencySystem is null or action is empty.");
            return;
        }
        if (emergency.isEmergencyDeclared()) {
            EmergencyResponseAction action = new EmergencyResponseAction(
                    getLastName() + " (PIC)",
                    actionDescription.trim(),
                    new Date()
            );
            emergency.logAction(action);
        } else {
            System.out.println(getLastName() + " tried to log action, but no emergency is active.");
        }
    }

    public boolean performPreFlightCheck(Object aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot perform pre-flight check: Aircraft object is null.");
            return false;
        }
        System.out.println("Pilot " + getLastName() + " performed pre-flight check on " + aircraft.getClass().getSimpleName());
        return true;
    }

    public void prepareFlightPlan(Object flight) {
        if (flight == null) {
            System.err.println("Cannot prepare flight plan: Flight object is null.");
            return;
        }
        System.out.println("Pilot " + getLastName() + " prepared flight plan for " + flight.getClass().getSimpleName());
    }

    public void flySegment(String routeSegment) {
        if (routeSegment == null || routeSegment.trim().isEmpty()) {
            System.err.println("Cannot fly segment: Route segment is empty.");
            return;
        }
        System.out.println("Pilot " + getLastName() + " is flying segment: " + routeSegment.trim());
    }

    public void handoverToCoPilot() {
        this.isOnDuty = false;
        System.out.println("Control handed over by Pilot " + getLastName());
    }

    public void recordFlightLog(FlightLog log) {
        if (log != null && log.hoursFlown() >= 0) {
            this.flightLogs.add(log);
            this.totalFlightHours += log.hoursFlown();
            System.out.println("Flight record processed. Hours added: " + log.hoursFlown() + ". Total hours updated to: " + totalFlightHours);
        } else {
            System.err.println("No valid flight log provided (log is null or hours are negative).");
        }
    }

    public void communicateWithATC(String atc, String message) {
        if (atc == null || atc.trim().isEmpty() || message == null || message.trim().isEmpty()) {
            System.err.println("Cannot communicate: ATC identifier or message is empty.");
            return;
        }
        System.out.println("Communicating with " + atc.trim() + ": '" + message.trim() + "'");
    }

    public void handleInFlightEmergency(EmergencySystem emergency, String emergencyDetails) {
        if (emergencyDetails == null || emergencyDetails.trim().isEmpty()) {
            System.err.println("Cannot handle emergency: Details are empty.");
            return;
        }
        String actionDescription = "Initiated emergency checklist for: " + emergencyDetails.trim();
        logEmergencyAction(emergency, actionDescription);
        System.out.println("Pilot " + getLastName() + " handling emergency: " + emergencyDetails.trim() + ".");
    }

    public void addRating(String rating) {
        if (rating != null && !rating.trim().isEmpty()) {
            String cleanRating = rating.trim();
            if (!this.ratings.contains(cleanRating)) {
                this.ratings.add(cleanRating);
                System.out.println("Added rating: " + cleanRating);
            }
        } else {
            System.err.println("Cannot add an empty rating.");
        }
    }

    // Getters and Setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getTotalFlightHours() {
        return totalFlightHours;
    }

    public List<String> getRatings() {
        return Collections.unmodifiableList(ratings);
    }

    public List<FlightLog> getFlightLogs() {
        return Collections.unmodifiableList(flightLogs);
    }

    public MedicalCertificate getMedicalCertificate() {
        return medicalCertificate;
    }

    public void setMedicalCertificate(MedicalCertificate medicalCertificate) {
        if (medicalCertificate != null) {
            this.medicalCertificate = medicalCertificate;
            System.out.println("Medical Certificate updated for Pilot " + getLastName());
        } else {
            System.err.println("Cannot set Medical Certificate to null.");
        }
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void toggleOnDuty(boolean onDuty) {
        this.isOnDuty = onDuty;
        System.out.println(getLastName() + " status set to On Duty: " + onDuty);
    }
}