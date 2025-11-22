// FINALIZED
import java.util.List;
import java.util.ArrayList;

public class Seat {
    // Properties (Fields)
    private final String seatNumber;
    private final SeatClass seatClass;
    private boolean isAvailable;
    private Passenger assignedPassenger;

    // Constructor
    public Seat(String seatNumber, SeatClass seatClass) {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be null or empty.");
        }
        if (seatClass == null) {
            throw new IllegalArgumentException("Seat class must be specified.");
        }

        this.seatNumber = seatNumber.trim();
        this.seatClass = seatClass;
        this.isAvailable = true;
        this.assignedPassenger = null;
    }

    // Methods
    public boolean assignToPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot assign null passenger to seat " + seatNumber);
            return false;
        }

        if (this.isAvailable) {
            this.assignedPassenger = passenger;
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseSeat() {
        if (!this.isAvailable) {
            this.assignedPassenger = null;
            this.isAvailable = true;
        }
    }

    // Getters and Setters
    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Passenger getAssignedPassenger() {
        return assignedPassenger;
    }
}