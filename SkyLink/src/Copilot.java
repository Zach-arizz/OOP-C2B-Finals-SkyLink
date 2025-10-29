import java.util.List;
import java.util.ArrayList;

public class Copilot extends Person {

    private String licenseNumber;
    private double totalFlightHours;
    private Pilot primaryPilot;
    private List<FlightLog> flightLogs;
    private boolean isOnDuty;

    public Copilot(long id, String firstName, String lastName, String contactNumber, String email, String address, String licenseNumber, Pilot primaryPilot) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.licenseNumber = licenseNumber;
        this.totalFlightHours = 0.0;
        this.primaryPilot = primaryPilot;
        this.flightLogs = new ArrayList<>();
        this.isOnDuty = false;
    }

    public void assistInFlightOperations () {
        System.out.println("Assisting the pilot in flight operations...");
    }

    public boolean performInstrumentCrossCheck() {
        return true;
    }

    public void monitorAircraftSystems() {
        System.out.println("Monitoring the aircraft systems...");
    }

    public void takeControlIfRequired() {
        System.out.println("Taking control if required...");
    }

    public void updateFlightLog(FlightLog log) { // void return
        this.flightLogs.add(log);
    }

    public void coordinateWithCabinCrew(String status) {
        System.out.println("Coordinating with cabin crew...");
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public double getTotalFlightHours() {
        return totalFlightHours;
    }

    public void addFlightHours(double flightHours) {
        this.totalFlightHours += flightHours;
    }

    public Pilot getPrimaryPilot() {
        return primaryPilot;
    }

    public void setPrimaryPilot(Pilot primaryPilot) {
        this.primaryPilot = primaryPilot;
    }

    public List<FlightLog> getFlightLogs() {
        return flightLogs;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }
}
