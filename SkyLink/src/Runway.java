import java.util.List;
import java.util.ArrayList;

enum RunwayStatus {
    OPEN,
    CLOSED
}

public class Runway {
    private String runwayId;
    private double length;
    private RunwayStatus status;
    private boolean isInstrumentLandingSystemEnabled;

    public Runway(String runwayId, double length, RunwayStatus status, boolean isInstrumentLandingSystemEnabled) {
        this.runwayId = runwayId;
        this.length = length;
        this.status = RunwayStatus.OPEN;
        this.isInstrumentLandingSystemEnabled = isInstrumentLandingSystemEnabled;
    }

    public boolean authorizeTakeoff(Flight flight) {
        System.out.println("Authorizing takeoff...");
        return this.status == RunwayStatus.OPEN;
    }

    public boolean authorizeLanding(Flight flight) {
        System.out.println("Authorizing landing...");
        return this.status == RunwayStatus.OPEN;
    }

    public void closeRunway(String reason) {
        System.out.println("Closing runway...");
        this.status = RunwayStatus.CLOSED;
    }

    public void openRunway() {
        System.out.println("Opening runway...");
        this.status = RunwayStatus.OPEN;
    }

    public void inspectSurface() {
        System.out.println("Inspecting surface...");
    }

    public boolean canSupportAircraft(Aircraft aircraft) {
        return true;
    }

    public String getRunwayId () {
        return runwayId;
    }

    public double getLength () {
        return length;
    }

    public RunwayStatus getStatus () {
        return status;
    }

    public boolean isInstrumentLandingSystemEnabled () {
        return isInstrumentLandingSystemEnabled;
    }

    public void setInstrumentLandingSystemEnabled (boolean isInstrumentLandingSystemEnabled) {
        this.isInstrumentLandingSystemEnabled = isInstrumentLandingSystemEnabled;
    }
}
