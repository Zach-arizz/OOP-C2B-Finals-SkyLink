import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Flight {
    // Properties (Fields)
    private final String flightNumber;
    private Airport origin;
    private Airport destination;
    private Schedule schedule;
    private FlightStatus status;
    private Aircraft assignedAircraft;
    private final List<Passenger> passengers;
    private final List<Seat> seats;

    // Constructor
    public Flight(String flightNumber, Airport origin, Airport destination) {
        if (flightNumber == null || flightNumber.trim().isEmpty() || origin == null || destination == null) {
            throw new IllegalArgumentException("Flight must have a valid flight number, origin, and destination.");
        }
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.passengers = new ArrayList<>();
        this.seats = new ArrayList<>();
        this.status = FlightStatus.SCHEDULED;
    }

    // Methods
    public void assignAircraft(Aircraft aircraft) {
        if (aircraft != null) {
            this.assignedAircraft = aircraft;
            System.out.println("Aircraft " + aircraft.getAircraftId() + " assigned to Flight " + this.flightNumber + ".");
        } else {
            System.err.println("Cannot assign a null aircraft to Flight " + this.flightNumber + ".");
        }
    }

    public void updateStatus(FlightStatus status) {
        if (status != null) {
            this.status = status;
            System.out.println("Status of Flight " + this.flightNumber + " updated to: " + status + ".");
        } else {
            System.err.println("Cannot update status with a null value for Flight " + this.flightNumber + ".");
        }
    }

    public void boardPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot board a null passenger.");
            return;
        }

        if (this.status == FlightStatus.BOARDING && !this.passengers.contains(passenger)) {
            this.passengers.add(passenger);
            System.out.println("Passenger " + passenger.getLastName() + " boarded Flight " + this.flightNumber + ".");
        } else if (this.status != FlightStatus.BOARDING) {
            System.out.println("Cannot board passenger. Flight is not currently boarding. Current status: " + this.status);
        } else {
            System.out.println("Passenger " + passenger.getLastName() + " is already on the manifest for Flight " + this.flightNumber + ".");
        }
    }

    public void finalizePassengerManifest() {
        System.out.println("Final passenger count for Flight " + this.flightNumber + ": " + this.passengers.size());
    }

    public double calculateDistance() {
        if (this.origin == null || this.destination == null) {
            System.err.println("Error calculating distance: Origin or destination airport is null.");
            return 0.0;
        }

        WaypointListManager manager = new WaypointListManager();
        List<Waypoint> route = new ArrayList<>();

        Waypoint originWp = origin.toWaypoint();
        Waypoint destinationWp = destination.toWaypoint();

        if (originWp == null || destinationWp == null) {
            System.err.println("Error calculating distance: Waypoint conversion failed.");
            return 0.0;
        }

        route.add(originWp);
        route.add(destinationWp);

        double distance = manager.computeDistanceKm(route);

        System.out.printf("Calculated flight distance between %s and %s: %.2f km.\n",
                origin.getAirportCode(), destination.getAirportCode(), distance);

        return distance;
    }

    public Duration estimateDuration() {
        if (this.assignedAircraft == null) {
            System.err.println("Cannot estimate duration: No aircraft is assigned to flight " + this.flightNumber + ".");
            return new Duration(0);
        }
        if (this.origin == null || this.destination == null) {
            System.err.println("Error estimating duration: Origin or destination airport is null.");
            return new Duration(0);
        }

        WaypointListManager manager = new WaypointListManager();
        List<Waypoint> route = new ArrayList<>();

        Waypoint originWp = origin.toWaypoint();
        Waypoint destinationWp = destination.toWaypoint();

        if (originWp == null || destinationWp == null) {
            System.err.println("Error estimating duration: Waypoint conversion failed.");
            return new Duration(0);
        }

        route.add(originWp);
        route.add(destinationWp);

        Duration duration = manager.estimateFlightDuration(route, this.assignedAircraft);

        System.out.printf("Estimated flight duration for %s to %s: %s.\n",
                origin.getAirportCode(), destination.getAirportCode(), duration.toFormattedString());

        return duration;
    }

    public void notifyDelays(String reason) {
        this.status = FlightStatus.DELAYED;
        System.out.println("NOTIFY: Flight " + this.flightNumber + " delayed due to: " + reason);
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        if (origin != null) {
            this.origin = origin;
        } else {
            System.err.println("Cannot set origin airport to null for Flight " + this.flightNumber + ".");
        }
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        if (destination != null) {
            this.destination = destination;
        } else {
            System.err.println("Cannot set destination airport to null for Flight " + this.flightNumber + ".");
        }
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        if (schedule != null) {
            this.schedule = schedule;
        } else {
            System.err.println("Cannot set a null schedule for Flight " + this.flightNumber + ".");
        }
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats);
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Aircraft getAssignedAircraft() {
        return assignedAircraft;
    }
}