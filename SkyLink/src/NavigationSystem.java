import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class NavigationSystem {

    // Properties (Fields)
    private NavigationRoute activeRoute;
    private String currentCoordinates;
    private double altitude;
    private double airspeed;
    private int currentWaypointIndex;

    // Constructor
    public NavigationSystem(String initialCoordinates, double initialAltitude, double initialAirspeed) {
        if (initialCoordinates == null || initialCoordinates.trim().isEmpty()) {
            throw new IllegalArgumentException("Initial coordinates cannot be null or empty.");
        }
        if (initialAltitude < 0 || initialAirspeed < 0) {
            throw new IllegalArgumentException("Altitude and airspeed cannot be negative.");
        }
        this.currentCoordinates = initialCoordinates.trim();
        this.altitude = initialAltitude;
        this.airspeed = initialAirspeed;
        this.activeRoute = null;
        this.currentWaypointIndex = 0;
    }

    // Methods
    public void receiveCriticalAlert(String alertType, String message) {
        if (alertType == null || alertType.trim().isEmpty() || message == null || message.trim().isEmpty()) {
            System.err.println("Cannot process alert: Type or message is invalid.");
            return;
        }
        System.out.println("--- NAVIGATION ALERT [" + alertType.toUpperCase() + "] ---");
        System.out.println("ACTION REQUIRED: " + message);
    }

    public void loadRoute(NavigationRoute route) {
        if (route == null) {
            System.err.println("Cannot load a null navigation route.");
            return;
        }
        this.activeRoute = route;
        this.currentWaypointIndex = 0;
        System.out.println("Navigation route loaded: " + route.getRouteId());
    }

    public void calculateRoute(String routeId, String airway, double expectedETD) {
        if (routeId == null || routeId.trim().isEmpty() || airway == null || airway.trim().isEmpty() || expectedETD < 0) {
            System.err.println("Cannot calculate route: Route ID, Airway, or valid ETD is missing.");
            return;
        }

        // 1. Create the base route object
        NavigationRoute newRoute = new NavigationRoute(routeId, airway, expectedETD);

        // 2. Add stubbed Waypoints to make the route functional
        newRoute.addWaypoint(new Waypoint("INIT", 34.05, -118.25, "Origin")); // Los Angeles
        newRoute.addWaypoint(new Waypoint("TOC", 36.77, -119.77, "Climb"));  // Fresno
        newRoute.addWaypoint(new Waypoint("DEST", 40.71, -74.00, "Destination")); // New York

        this.loadRoute(newRoute);
    }

    public void updatePosition(String newCoordinates) {
        if (newCoordinates != null && !newCoordinates.trim().isEmpty()) {
            this.currentCoordinates = newCoordinates.trim();
        } else {
            System.err.println("Cannot update position: Coordinates are invalid.");
        }
    }

    public void adjustAltitude(double newAltitude) {
        if (newAltitude >= 0) {
            this.altitude = newAltitude;
        } else {
            System.err.println("Cannot set altitude to a negative value.");
        }
    }

    public void setAirspeed(double airspeed) {
        if (airspeed >= 0) {
            this.airspeed = airspeed;
        } else {
            System.err.println("Cannot set airspeed to a negative value.");
        }
    }

    public void adjustCourse(String navInstruction) {
        if (navInstruction != null && !navInstruction.trim().isEmpty()) {
            System.out.println("Course adjusted based on instruction: " + navInstruction);
        } else {
            System.err.println("Cannot adjust course: Instruction is missing.");
        }
    }

    public NavigationReport generateNavigationReport() {
        String nextWp = "N/A";
        double dist = 0.0;

        // Check for an active route and ensure the index is valid
        if (activeRoute != null && activeRoute.getWaypoints() != null && activeRoute.getWaypoints().size() > currentWaypointIndex) {
            Waypoint nextWaypoint = activeRoute.getWaypoints().get(currentWaypointIndex);
            nextWp = nextWaypoint.identifier();

            dist = 50.0;
        }

        // Assuming NavigationReport constructor takes all fields
        return new NavigationReport(
                new Date(),
                "AIRCRAFT_ID_PLACEHOLDER",
                this.currentCoordinates,
                this.altitude,
                this.airspeed,
                nextWp,
                dist
        );
    }

    // Getters and Setters
    public NavigationRoute getActiveRoute() {
        return activeRoute;
    }

    public String getCurrentCoordinates() {
        return currentCoordinates;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getAirspeed() {
        return airspeed;
    }

    public int getCurrentWaypointIndex() {
        return currentWaypointIndex;
    }

    public void setCurrentWaypointIndex(int currentWaypointIndex) {
        if (currentWaypointIndex >= 0) {
            this.currentWaypointIndex = currentWaypointIndex;
        } else {
            System.err.println("Waypoint index cannot be negative.");
        }
    }
}