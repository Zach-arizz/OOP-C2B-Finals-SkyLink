import java.util.Date;

public record NavigationReport(
        Date timestamp,
        String aircraftId,
        String currentCoordinates,
        double altitude,
        double airspeed,
        String nextWaypointIdentifier,
        double distanceToNextWaypointKm
) {

    public String getStatusSummary() {
        return String.format("Current Position: %s at %.0f ft. Next WP: %s (%.1f km away).",
                currentCoordinates, altitude, nextWaypointIdentifier, distanceToNextWaypointKm);
    }
}
