import java.util.List;
import java.util.ArrayList;

public class Passenger extends Person{

    class Booking {}
    class Ticket {}
    class Flight {}
    class SeatClass {}
    class PaymentMethod {}
    class CheckIn {}
    class Refund {}

    private String passengerId;
    private String passportNumber;
    private String nationality;
    private int loyaltyPoints;
    private List<Booking> bookings;
    private List<Ticket> tickets;

    public Passenger (long id, String firstName, String lastName, String contactNumber, String email, String address, String passengerId, String passportNumber, String nationality) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.passengerId = passengerId;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.loyaltyPoints = 0;
        this.bookings = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Booking requestBooking(Flight flight, SeatClass seatClass, int numSeats) {
        return new Booking();
    }

    public boolean makePayment(PaymentMethod method, double amount) {
        return true;
    }

    public CheckIn performOnlineCheckIn(Flight flight) {
        return new CheckIn();
    }

    public Ticket getTicket(String ticketNumber) {
        return new Ticket();
    }

    public Refund requestRefund(String ticketNumber, String reason) {
        return null;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void redeemLoyaltyPoints(int points) {
        if (loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
        }
    }
}
