// FINALIZED
import java.util.Collections;

public class OnlineCheckin {
    // Properties (Fields)
    private boolean seatSelectionAvailable;
    private boolean baggagePreCheckAvailable;
    private final String checkInURL;

    // Constructor
    public OnlineCheckin(String url, boolean seats, boolean baggage) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("Check-in URL cannot be null or empty.");
        }

        this.checkInURL = url.trim();
        this.seatSelectionAvailable = seats;
        this.baggagePreCheckAvailable = baggage;
    }

    // Methods
    public CheckIn startOnlineCheckIn(Passenger passenger, Flight flight) {
        if (passenger == null || flight == null) {
            System.err.println("Cannot start check-in: Passenger or Flight is null.");
            return null;
        }
        System.out.println("Starting online check-in for " + passenger.getFullName());
        return new CheckIn("OLC" + passenger.getId(), passenger, flight);
    }

    public boolean selectSeat(Seat seat) {
        if (seat == null) {
            System.err.println("Cannot select null seat.");
            return false;
        }
        return seatSelectionAvailable && seat.isAvailable();
    }

    public BoardingPass downloadBoardingPass(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot download boarding pass for null passenger.");
            return null;
        }
        System.out.println("Generating downloadable boarding pass.");
        return null;
    }

    public void verifyPassengerIdentity(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot verify null passenger identity.");
            return;
        }
        System.out.println("Verifying identity for " + passenger.getPassportNumber());
    }

    public void updateSpecialRequests(Passenger passenger, String request) {
        if (passenger == null || request == null || request.trim().isEmpty()) {
            System.err.println("Cannot update special requests: Input invalid.");
            return;
        }
        System.out.println("Adding request: " + request);
    }

    // Getters and Setters
    public boolean isSeatSelectionAvailable() {
        return seatSelectionAvailable;
    }

    public void setSeatSelectionAvailable(boolean seatSelectionAvailable) {
        this.seatSelectionAvailable = seatSelectionAvailable;
    }

    public boolean isBaggagePreCheckAvailable() {
        return baggagePreCheckAvailable;
    }

    public void setBaggagePreCheckAvailable(boolean baggagePreCheckAvailable) {
        this.baggagePreCheckAvailable = baggagePreCheckAvailable;
    }

    public String getCheckInURL() {
        return checkInURL;
    }
}
