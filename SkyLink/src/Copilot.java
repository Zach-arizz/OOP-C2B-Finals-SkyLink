import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Copilot extends Person {
    // Properties (Fields)
    private final String licenseNumber;
    private double totalFlightHours;
    private Pilot primaryPilot;
    private final List<FlightLog> flightLogs;
    private boolean isOnDuty;

    // Constructor
    public Copilot(long id, String firstName, String lastName, String contactNumber, String email, String address,
                   String licenseNumber, double totalFlightHours) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.licenseNumber = licenseNumber;
        this.totalFlightHours = totalFlightHours;
        this.flightLogs = new ArrayList<>();
        this.isOnDuty = false;
        this.primaryPilot = null;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Co Pilot (License: " + this.licenseNumber + ", Hours: " + this.totalFlightHours + ")";
    }

    public void assistInFlightOperations() {
        System.out.println(getLastName() + " is assisting with in-flight operations.");
    }

    public boolean performInstrumentCrossCheck() {
        System.out.println(getLastName() + " performing instrument cross-check and checklist verification.");
        return true;
    }

    public void monitorAircraftSystems() {
        System.out.println(getLastName() + " is monitoring all aircraft systems.");
    }

    public void takeControlIfRequired() {
        if (this.isOnDuty) {
            System.out.println(getLastName() + " has taken temporary control of the aircraft (Pilot-Flying).");
        } else {
            System.out.println(getLastName() + " is not on duty and cannot take control.");
        }
    }

    public void updateFlightLog(FlightLog log) {
        if (log != null) {
            this.flightLogs.add(log);
            this.totalFlightHours += log.hoursFlown(); // Update total hours using the FlightLog field
            System.out.println("Flight log updated by " + getLastName() + ". Hours added: " + log.hoursFlown());
        } else {
            System.out.println("Cannot update log: Provided FlightLog is null.");
        }
    }

    public void coordinateWithCabinCrew(String status) {
        System.out.println("Coordinating with Cabin Crew: " + status);
    }

    // Getters and Setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getTotalFlightHours() {
        return totalFlightHours;
    }

    public Pilot getPrimaryPilot() {
        return primaryPilot;
    }

    public void setPrimaryPilot(Pilot primaryPilot) {
        this.primaryPilot = primaryPilot;
        System.out.println(getLastName() + " is now flying with Captain " + (primaryPilot != null ? primaryPilot.getLastName() : "Unknown"));
    }

    public List<FlightLog> getFlightLogs() {
        return Collections.unmodifiableList(flightLogs);
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void toggleOnDuty(boolean onDuty) {
        this.isOnDuty = onDuty;
        System.out.println(getLastName() + " status set to On Duty: " + onDuty);
    }
}
