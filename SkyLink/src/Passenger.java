import java.util.List;
import java.util.ArrayList;

public class Passenger extends Person {
    private String passportNumber;
    private String nationality;
    private int loyaltyPoints;
    private final List<Booking> bookings;
    private final List<Ticket> tickets;

    public Passenger(long id, String firstName, String lastName, String contactNumber, String email, String address,
                     String passportNumber, String nationality) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.loyaltyPoints = 0;
        this.bookings = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    @Override
    public String getRoleDescription() {
        return "Passenger (Passport: " + this.passportNumber + ")";
    }

    public Booking requestBooking(Flight flight, String seatClass, int numSeats) {
        System.out.println("Booking requested for " + getFullName() + " on flight " + flight.getFlightNumber());
        return null;
    }

    public boolean makePayment(String paymentMethod, double amount) {
        System.out.println("Processing payment of $" + amount + " for " + getFullName());
        return true;
    }

    public void performOnlineCheckin(Flight flight) {
        System.out.println("Online check-in performed for flight " + flight.getFlightNumber() + " by " + getFullName());
    }

    public Ticket getTicket(String ticketNumber) {
        System.out.println("Searching for ticket: " + ticketNumber);
        return null;
    }

    public void requestRefund(String ticketNumber, String reason) {
        System.out.println("Refund requested for ticket " + ticketNumber + " by " + getFullName());
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
        System.out.println(points + " loyalty points added. New balance: " + this.loyaltyPoints);
    }

    public void redeemLoyaltyPoints(int points) {
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            System.out.println(points + " loyalty points redeemed. Remaining balance: " + this.loyaltyPoints);
        } else {
            System.out.println("Insufficient loyalty points to redeem " + points + ".");
        }
    }

    // Getters and Setters
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}