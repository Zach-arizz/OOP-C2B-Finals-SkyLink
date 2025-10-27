import java.util.List;
import java.util.ArrayList;

public class Pilot extends Person {

    class Flight {}
    class Aircraft {}
    class NavigationRoute {}
    class EmergencySituation {}
    class AirTrafficControl {}
    class EmergencySystem {}
    class FlightLog {}
    class MedicalCertificate {}

    private String licenseNumber;
    private double totalFlightHours;
    private List<String> ratings;             
    private List<FlightLog> flightLogs;        
    private MedicalCertificate medicalCertificate;
    private boolean isOnDuty;

    public Pilot(long id, String firstName, String lastName, String contactNumber, String email, String address,
                 String licenseNumber, MedicalCertificate medicalCertificate) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.licenseNumber = licenseNumber;
        this.totalFlightHours = 0.0;
        this.ratings = new ArrayList<>();
        this.flightLogs = new ArrayList<>();
        this.medicalCertificate = medicalCertificate;
        this.isOnDuty = false;
    }

    public void prepareFlightPlan(Flight flight) {
        System.out.println("Preparing flight plan for flight...");
    }

    public boolean performPreFlightCheck(Aircraft aircraft) {
        System.out.println("Performing pre-flight check...");
        return true; 
    }

    public void flySegment(NavigationRoute routeSegment) {
        System.out.println("Flying route segment...");
    }

    public void handleEmergency(EmergencySituation emergency) {
        System.out.println("Handling emergency: " + emergency.toString());
    }

    public void communicateWithATC(AirTrafficControl atc, String message) {
        System.out.println("Communicating with ATC: " + message);
    }

    public void handleInFlightEmergency(EmergencySystem emergencySystem) {
        System.out.println("Managing in-flight emergency...");
    }

    public void recordFlightLog(FlightLog log) {
        this.flightLogs.add(log);
        System.out.println("Flight log recorded.");
    }

    public void handoverToCoPilot() {
        System.out.println("Handover to co-pilot complete.");
    }

    public void addFlightHours(double hours) {
        this.totalFlightHours += hours;
    }

    public void addRating(String rating) {
        this.ratings.add(rating);
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.isOnDuty = onDuty;
    }
}
