import java.util.List;
import java.util.ArrayList;

class Runway {}
class Clearance {}

public class AirTrafficController extends Person {
    private String controllerId;
    private String controlTowerSector;
    private List<Runway> managedRunways;
    private List<Flight> activeFlights;
    private ShiftSchedule shiftSchedule;

    public AirTrafficController(long id, String firstName, String lastName, String contactNumber, String email, String address, String controllerId, String controlTowerSector, ShiftSchedule shiftSchedule) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.controllerId = controllerId;
        this.controlTowerSector = controlTowerSector;
        this.managedRunways = new ArrayList<>();
        this.activeFlights = new ArrayList<>();
        this.shiftSchedule = shiftSchedule;
    }

    public Clearance authorizeTakeoff(Flight flight, Runway runway) {
        System.out.println("Authorizing Takeoff...");
        return new Clearance();
    }

    public Clearance authorizeLanding(Flight flight, Runway runway) {
        System.out.println("Authorizing Landing...");
        return new Clearance();
    }

    public void manageAirspaceTraffic(){
        System.out.println("Manage Airspace Traffic...");
    }

    public void provideVectoringInstructions(Flight flight, NavigationRoute route) {
        System.out.println("Providing Vectoring Instructions...");
    }

    public void handleEmergencyPriority(EmergencySystem emergency, Flight flight) {
        System.out.println("Handling Emergency Priority...");
    }

    public void logATCCommunication(String message) {
        System.out.println("Logging ATC Communication...");
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    public String getControlTowerSector() {
        return controlTowerSector;
    }

    public void setControlTowerSector(String controlTowerSector) {
        this.controlTowerSector = controlTowerSector;
    }

    public List<Runway> getManagedRunways() {
        return managedRunways;
    }

    public void addManagedRunway(Runway runway) {
        this.managedRunways.add(runway);
    }

    public List<Flight> getActiveFlights() {
        return activeFlights;
    }

    public void addActiveFlight(Flight flight) {
        this.activeFlights.add(flight);
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(ShiftSchedule shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }
}
