// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NavigationRoute {
    // Properties (Fields)
    private final String routeId;
    private final String airway;
    private final List<Waypoint> waypoints;
    private final List<String> restrictions;
    private final WaypointListManager distanceManager;

    private double expectedETD;
    private double totalDistanceKm;

    // Constructor
    public NavigationRoute(String routeId, String airway, double expectedETD) {
        if (routeId == null || routeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Route ID cannot be null or empty.");
        }
        if (airway == null || airway.trim().isEmpty()) {
            throw new IllegalArgumentException("Airway name cannot be null or empty.");
        }
        if (expectedETD < 0) {
            throw new IllegalArgumentException("Expected ETD cannot be negative.");
        }

        this.routeId = routeId.trim();
        this.airway = airway.trim();
        this.expectedETD = expectedETD;
        this.waypoints = new ArrayList<>();
        this.restrictions = new ArrayList<>();
        this.distanceManager = new WaypointListManager();
        this.totalDistanceKm = 0.0;
    }

    // Methods
    public void addWaypoint(Waypoint wp) {
        if (wp != null) {
            this.waypoints.add(wp);
            this.totalDistanceKm = computeDistanceKm();
        } else {
            System.err.println("Cannot add a null Waypoint.");
        }
    }

    public void removeWaypoint(Waypoint wp) {
        if (wp != null && this.waypoints.remove(wp)) {
            this.totalDistanceKm = computeDistanceKm();
        } else if (wp == null) {
            System.err.println("Cannot remove a null Waypoint.");
        }
    }

    public void addRestriction(String restriction) {
        if (restriction != null && !restriction.trim().isEmpty()) {
            this.restrictions.add(restriction.trim());
        } else {
            System.err.println("Cannot add an empty restriction.");
        }
    }

    public void removeRestriction(String restriction) {
        if (restriction != null) {
            this.restrictions.remove(restriction);
        }
    }

    public double computeDistanceKm() {
        return distanceManager.computeDistanceKm(this.waypoints);
    }

    public boolean containsWaypoint(Waypoint wp) {
        return waypoints.contains(wp);
    }

    public String segmentBetween(Waypoint from, Waypoint to) {
        if (from == null || to == null) {
            return "Segment calculation failed: Waypoints must be valid.";
        }
        // Uses AviationMath utility (as noted)
        double segmentDist = AviationMath.calculateDistanceBetween(from, to);
        return String.format("Segment from %s to %s via %s (Distance: %.2f km)",
                from.identifier(),
                to.identifier(),
                this.airway,
                segmentDist);
    }

    public Duration estimateTimeEnroute(Object aircraft) {
        // Delegates to WaypointListManager (as noted)
        return distanceManager.estimateFlightDuration(this.waypoints, aircraft);
    }

    // Getters and Setters
    public String getRouteId() {
        return routeId;
    }

    public String getAirway() {
        return airway;
    }

    public List<Waypoint> getWaypoints() {
        return Collections.unmodifiableList(waypoints);
    }

    public List<String> getRestrictions() {
        return Collections.unmodifiableList(restrictions);
    }

    public double getTotalDistanceKm() {
        return totalDistanceKm;
    }

    public double getExpectedETD() {
        return expectedETD;
    }

    public void setExpectedETD(double expectedETD) {
        if (expectedETD >= 0) {
            this.expectedETD = expectedETD;
        } else {
            System.err.println("Expected ETD cannot be set to a negative value.");
        }
    }
}