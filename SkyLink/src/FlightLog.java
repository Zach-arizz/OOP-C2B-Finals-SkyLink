// FINALIZED
import java.util.Date;

public record FlightLog(Date flightDate, double hoursFlown, String routeFlown, String aircraftId, String pilotInCommandLicense ) {
    public FlightLog {
        if (hoursFlown < 0) {
            hoursFlown = 0;
        }
    }
}