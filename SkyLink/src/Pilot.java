import java.util.List;
import java.util.ArrayList;

class Aircraft {}
class NavigationRoute {}
class AirTrafficControl {}
class EmergencySystem {}
class EmergencyAction {}
class FlightLog {}
class MedicalCertificate {}

public class Pilot extends Person {

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

    public void handoverToCoPilot() {
        System.out.println("Handover to co-pilot complete.");
    }

    public void recordFlightLog(FlightLog log) {
        this.flightLogs.add(log);
        System.out.println("Flight log recorded.");
    }

    public void communicateWithATC(AirTrafficControl atc, String message) {
        System.out.println("Communicating with ATC: " + message);
    }

    public EmergencyAction handleInFlightEmergency(EmergencySystem emergencySystem) {
        System.out.println("Managing in-flight emergency...");
        return new EmergencyAction();
    }

    public String getLicenseNumber () {
        return licenseNumber;
    }

    public void setLicenseNumber (String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public double getTotalFlightHours () {
        return totalFlightHours;
    }

    public void addFlightHours (double flightHours) {
        this.totalFlightHours += flightHours;
    }

    public List<String> getRatings () {
        return ratings;
    }

    public void addRating(String rating) {
        this.ratings.add(rating);
    }

    public List <FlightLog> getFlightLogs () {
        return flightLogs;
    }

    public MedicalCertificate getMedicalCertificate () {
        return medicalCertificate;
    }

    public void setMedicalCertificate (MedicalCertificate medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }

    public boolean isOnDuty () {
        return isOnDuty;
    }

    public void setOnDuty (boolean onDuty) {
        this.isOnDuty = onDuty;
    }
}
