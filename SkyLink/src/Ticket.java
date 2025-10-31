import java.util.Date;

public class Ticket {
    // Properties (Fields)
    private final String ticketNumber;
    private Booking booking;
    private double price;
    private final Date issueDate;
    private boolean isUsed;

    // Constructor
    public Ticket(String ticketNumber, Booking booking, double price) {
        if (ticketNumber == null || ticketNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket number cannot be null or empty.");
        }
        if (booking == null) {
            throw new IllegalArgumentException("Booking must be provided.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }

        this.ticketNumber = ticketNumber.trim();
        this.booking = booking;
        this.price = price;
        this.issueDate = new Date();
        this.isUsed = false;
    }

    // Methods
    public void markAsUsed() {
        if (!this.isUsed) {
            this.isUsed = true;
            System.out.println("Ticket " + this.ticketNumber + " marked as used.");
        } else {
            System.out.println("Ticket " + this.ticketNumber + " is already used.");
        }
    }

    public void revalidateTicket() {
        if (this.isUsed) {
            this.isUsed = false;
            System.out.println("Ticket " + this.ticketNumber + " revalidated (Unused).");
        } else {
            System.out.println("Ticket " + this.ticketNumber + " is already valid.");
        }
    }

    public Passenger getTicketHolder() {
        if (this.booking == null) {
            System.err.println("Cannot retrieve ticket holder: Booking is null.");
            return null;
        }
        System.out.println("Retrieving ticket holder via booking.");
        return this.booking.getPassenger();
    }

    public Flight getFlightDetails() {
        if (this.booking == null) {
            System.err.println("Cannot retrieve flight details: Booking is null.");
            return null;
        }
        System.out.println("Retrieving flight details via booking.");
        return this.booking.getFlight();
    }

    // Getters and Setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        if (booking == null) {
            System.err.println("Booking cannot be set to null.");
            return;
        }
        this.booking = booking;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.err.println("Price must be positive.");
            return;
        }
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public boolean isUsed() {
        return isUsed;
    }
}