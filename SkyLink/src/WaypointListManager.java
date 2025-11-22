// FINALIZED
import java.util.List;

public class WaypointListManager {
    public double computeDistanceKm(List<Waypoint> waypoints) {
        if (waypoints == null || waypoints.size() < 2) {
            return 0.0;
        }

        double totalDistance = 0.0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint start = waypoints.get(i);
            Waypoint end = waypoints.get(i + 1);

            totalDistance += AviationMath.calculateDistanceBetween(start, end);
        }
        return totalDistance;
    }

    public Duration estimateFlightDuration(List<Waypoint> waypoints, Object aircraft) {
        // Calculate distance internally
        double totalDistanceKm = computeDistanceKm(waypoints);

        if (totalDistanceKm > 0) {
            // Simplified estimation logic: assuming an average cruise speed of 800 km/h
            final double AVERAGE_CRUISE_SPEED_KMH = 800.0;
            double hours = totalDistanceKm / AVERAGE_CRUISE_SPEED_KMH;
            long minutes = (long) (hours * 60);
            return new Duration(minutes);
        }
        return new Duration(0);
    }
}