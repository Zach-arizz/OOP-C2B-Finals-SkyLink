import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Route {
    // Properties (Fields)
    private static final double AVERAGE_FUEL_BURN_KG_PER_KM = 4.2;
    private final WaypointListManager distanceManager = new WaypointListManager();
    private Airport origin;
    private Airport destination;
    private final List<Waypoint> waypoints;
    private double totalDistanceKm;

    // Constructor
    public Route(Airport origin, Airport destination) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Origin and destination airports must be provided.");
        }
        this.origin = origin;
        this.destination = destination;
        this.waypoints = new ArrayList<>();
        this.totalDistanceKm = 0.0;
    }

    // Methods
    public void addWaypoint(Waypoint wp) {
        if (wp != null) {
            this.waypoints.add(wp);
            this.totalDistanceKm = computeDistanceKm();
            System.out.println("Added waypoint: " + wp.identifier());
        } else {
            System.err.println("Cannot add a null waypoint.");
        }
    }

    public void removeWaypoint(Waypoint wp) {
        if (wp != null && this.waypoints.remove(wp)) {
            this.totalDistanceKm = computeDistanceKm();
            System.out.println("Removed waypoint: " + wp.identifier());
        } else if (wp != null) {
            System.out.println("Waypoint " + wp.identifier() + " not found in the route.");
        } else {
            System.err.println("Cannot remove a null waypoint.");
        }
    }

    public double computeDistanceKm() {
        if (this.waypoints.isEmpty()) {
            return 0.0;
        }
        return distanceManager.computeDistanceKm(this.waypoints);
    }

    public Duration estimateFlightDuration(Object aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot estimate duration: Aircraft object is null.");
            return null;
        }
        return distanceManager.estimateFlightDuration(this.waypoints, aircraft);
    }

    public double estimateFuelRequired(Object aircraft) {
        if (aircraft == null) {
            System.err.println("Cannot estimate fuel: Aircraft object is null.");
            return 0.0;
        }
        double estimatedFuel = this.totalDistanceKm * AVERAGE_FUEL_BURN_KG_PER_KM;
        System.out.println("Estimating fuel required: " + estimatedFuel + " kg.");
        return estimatedFuel;
    }

    // Getters and Setters
    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        if (origin != null) {
            this.origin = origin;
        } else {
            System.err.println("Origin cannot be set to null.");
        }
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        if (destination != null) {
            this.destination = destination;
        } else {
            System.err.println("Destination cannot be set to null.");
        }
    }

    public double getDistanceKm() {
        return totalDistanceKm;
    }

    public List<Waypoint> getWaypoints() {
        return Collections.unmodifiableList(waypoints);
    }
}