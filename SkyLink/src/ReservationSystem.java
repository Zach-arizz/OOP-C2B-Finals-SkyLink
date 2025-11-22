// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReservationSystem {
    // Properties (Fields)
    private final List<Booking> bookings;
    private List<Flight> flights;
    private final List<Passenger> registeredPassengers;

    // Constructor
    public ReservationSystem() {
        this.bookings = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.registeredPassengers = new ArrayList<>();
    }

    // Methods
    public Booking createBooking(Passenger passenger, Flight flight) {
        if (passenger == null || flight == null) {
            System.err.println("Cannot create booking: Passenger or Flight cannot be null.");
            return null;
        }

        String newBookingId = "BOOK-" + (bookings.size() + 1);
        if (!registeredPassengers.contains(passenger)) {
            registeredPassengers.add(passenger);
        }

        Booking newBooking = new Booking(newBookingId, passenger, flight);
        this.bookings.add(newBooking);

        System.out.println("Created new booking " + newBookingId + " for " + passenger.getLastName() + " on flight " + flight.getFlightNumber() + ".");
        return newBooking;
    }

    public void manageFlightStatus(Flight flight) {
        if (flight == null) {
            System.err.println("Cannot manage status: Flight cannot be null.");
            return;
        }
        FlightStatus currentStatus = flight.getStatus();
        System.out.println("Reservation System checking status for " + flight.getFlightNumber() + ". Current: " + currentStatus + ".");
    }

    public List<Flight> searchFlights(Airport origin, Airport destination, Date date) {
        if (origin == null || destination == null || date == null) {
            System.err.println("Cannot search flights: Origin, destination, or date cannot be null.");
            return Collections.emptyList();
        }

        System.out.println("Searching flights from " + origin.getAirportCode() + " to " + destination.getAirportCode() + " on " + date + ".");
        return this.flights.stream()
                .filter(f -> f.getOrigin().equals(origin) && f.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    public void cancelBooking(String bookingId) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            System.err.println("Cannot cancel booking: Booking ID is empty.");
            return;
        }
        boolean removed = this.bookings.removeIf(b -> b.getBookingId().equals(bookingId.trim()));
        if (removed) {
            System.out.println("Booking " + bookingId.trim() + " successfully cancelled and removed from system.");
        } else {
            System.out.println("Error: Booking " + bookingId.trim() + " not found.");
        }
    }

    public void updateBookingStatus(Booking booking, Object bookingStatus) {
        if (booking == null || bookingStatus == null) {
            System.err.println("Cannot update status: Booking or new status cannot be null.");
            return;
        }
        System.out.println("Updating status for booking " + booking.getBookingId() + " to new status.");
    }

    // Getters and Setters
    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public List<Flight> getFlights() {
        return Collections.unmodifiableList(flights);
    }

    public void setFlights(List<Flight> flights) {
        if (flights != null) {
            this.flights = flights;
        } else {
            System.err.println("Cannot set flights list to null.");
        }
    }

    public List<Passenger> getRegisteredPassengers() {
        return Collections.unmodifiableList(registeredPassengers);
    }
}