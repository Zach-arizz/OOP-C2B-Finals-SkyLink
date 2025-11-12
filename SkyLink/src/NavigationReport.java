import java.util.Date;

/**
 * Class 70a of 78: NavigationReport (Java Record)
 * An immutable data container capturing the state of the navigation system at a specific time.
 */
public record NavigationReport(
        Date timestamp,
        String aircraftId,
        String currentCoordinates,
        double altitude,
        double airspeed,
        String nextWaypointIdentifier,
        double distanceToNextWaypointKm
) {
    /**
     * Provides a summary of the navigation status.
     */
    public String getStatusSummary() {
        return String.format("Current Position: %s at %.0f ft. Next WP: %s (%.1f km away).",
                currentCoordinates, altitude, nextWaypointIdentifier, distanceToNextWaypointKm);
    }
}
