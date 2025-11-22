import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Booking {
    // Properties (Fields)
    private final String bookingId;
    private final Passenger passenger;
    private final Flight flight;
    private final List<Seat> reservedSeats;
    private final Date bookingDate;
    private BookingStatus status;
    private double totalPrice;

    // Constructor
    public Booking(String bookingId, Passenger passenger, Flight flight) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.reservedSeats = new ArrayList<>();
        this.bookingDate = new Date();
        this.status = BookingStatus.PENDING;
        this.totalPrice = 0.0;
    }

    // Methods
    public void calculateTotalFare() {
        double baseFare = 350.0;
        double seatFee = reservedSeats.size() * 5.0;
        this.totalPrice = baseFare + seatFee;
        System.out.println("Total fare calculated: $" + this.totalPrice);
    }

    public void confirmBooking() {
        if (this.status == BookingStatus.PENDING) {
            this.status = BookingStatus.CONFIRMED;
            System.out.println("Booking " + this.bookingId + " confirmed.");
            this.calculateTotalFare();
        } else {
            System.out.println("Cannot confirm booking " + this.bookingId + ". Current status: " + this.status);
        }
    }

    public void cancelBooking(String reason) {
        if (!this.status.isFinal()) {
            this.status = BookingStatus.CANCELLED;
            System.out.println("Booking " + this.bookingId + " cancelled due to: " + reason);
        } else {
            System.out.println("Booking " + this.bookingId + " is already in a final state: " + this.status);
        }
    }

    public void checkIn() {
        if (this.status == BookingStatus.CONFIRMED) {
            this.status = BookingStatus.CHECKED_IN;
            System.out.println("Booking " + this.bookingId + " checked in.");
        } else {
            System.out.println("Cannot check in booking " + this.bookingId + ". Status must be CONFIRMED.");
        }
    }

    public void assignSeat(Seat seat) {
        if (seat != null && !reservedSeats.contains(seat) && this.status.isBooked()) {
            reservedSeats.add(seat);
            System.out.println("Seat " + seat.getSeatNumber() + " assigned to booking " + this.bookingId + ".");
            this.calculateTotalFare();
        }
    }

    public Ticket generateTicket() {
        if (this.totalPrice == 0.0) {
            this.calculateTotalFare();
        }
        String newTicketNumber = "TICKET-" + this.bookingId + "-" + System.currentTimeMillis();

        Ticket ticket = new Ticket(newTicketNumber, this, this.totalPrice);
        System.out.println("Ticket " + newTicketNumber + " generated for booking " + this.bookingId + ".");
        return ticket;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<Seat> getReservedSeats() {
        return Collections.unmodifiableList(reservedSeats);
    }

    public Date getBookingDate() {
        return (Date) bookingDate.clone();
    }

    public BookingStatus getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
