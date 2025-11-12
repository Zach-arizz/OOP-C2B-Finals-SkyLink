import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class AirTrafficController extends Person {
    // Properties (Fields)
    private String controlTowerSector;
    private final List<Runway> managedRunways;
    private final List<Flight> activeFlights;
    private ShiftSchedule shiftSchedule;

    // Constructor
    public AirTrafficController(long id, String firstName, String lastName, String contactNumber, String email, String address, String controlTowerSector) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.controlTowerSector = controlTowerSector;
        this.managedRunways = new ArrayList<>();
        this.activeFlights = new ArrayList<>();
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Air Traffic Controller (Sector: " + this.controlTowerSector + ", ID: " + this.getId() + ")";
    }

    public Clearance authorizeTakeoff(Flight flight, Runway runway) {
        String flightId = (flight != null) ? flight.getFlightNumber() : "UNKNOWN";
        String runwayId = (runway != null) ? runway.getRunwayId() : "UNK";

        Clearance takeoffClearance = new Clearance(
                "CL-" + flightId + "-TO",
                flightId,
                "Cleared for takeoff.",
                "Runway " + runwayId,
                new Date(),
                null,
                new Date(System.currentTimeMillis() + 60000) // Expires in 60 seconds
        );
        System.out.println("ATC authorizes takeoff for Flight " + flightId + " on Runway " + runwayId + ". Clearance ID: " + takeoffClearance.clearanceId());
        return takeoffClearance;
    }

    public Clearance authorizeLanding(Flight flight, Runway runway) {
        String flightId = (flight != null) ? flight.getFlightNumber() : "UNKNOWN";
        String runwayId = (runway != null) ? runway.getRunwayId() : "UNK";

        Clearance landingClearance = new Clearance(
                "CL-" + flightId + "-LND",
                flightId,
                "Cleared to land.",
                "Runway " + runwayId,
                new Date(),
                null,
                null
        );
        System.out.println("ATC authorizes landing for Flight " + flightId + " on Runway " + runwayId + ". Clearance ID: " + landingClearance.clearanceId());
        return landingClearance;
    }

    public void manageAirspaceTraffic() {
        System.out.println("Managing traffic in sector: " + this.controlTowerSector);
    }

    public void provideVectoringInstructions(Flight flight, NavigationRoute routeSegment) {
        System.out.println("Providing vectoring instructions to Flight " + flight.getFlightNumber() + ".");
    }

    public void handleEmergencyPriority(EmergencySystem emergency, Flight flight, Airport airport) {
        String flightId = (flight != null) ? flight.getFlightNumber() : "UNKNOWN";
        if (emergency != null && emergency.isEmergencyDeclared()) {
            System.out.println("ATC prioritizing emergency handling for Flight " + flightId + " in sector " + this.controlTowerSector + ".");
            emergency.coordinateWithATCForPriority(this, "Cleared immediate approach and landing priority.");
            emergency.notifyRescueServices(airport);
        } else {
            System.out.println("Received priority request from " + flightId + ", but no active emergency in system.");
        }
    }

    public void logATCCommunication(String message) {
        System.out.println("Logging communication: " + message);
    }

    // Getters and Setters
    public String getControlTowerSector() {
        return controlTowerSector;
    }

    public void setControlTowerSector(String controlTowerSector) {
        this.controlTowerSector = controlTowerSector;
    }

    public List<Runway> getManagedRunways() {
        return Collections.unmodifiableList(managedRunways);
    }

    public void addManagedRunway(Runway runway) {
        if (runway != null) this.managedRunways.add(runway);
    }

    public void removeManagedRunway(Runway runway) {
        this.managedRunways.remove(runway);
    }

    public List<Flight> getActiveFlights() {
        return Collections.unmodifiableList(activeFlights);
    }

    public void addActiveFlight(Flight flight) {
        if (flight != null) this.activeFlights.add(flight);
    }

    public void removeActiveFlight(Flight flight) {
        this.activeFlights.remove(flight);
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(ShiftSchedule shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }
}