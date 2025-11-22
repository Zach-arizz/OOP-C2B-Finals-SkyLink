// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CheckIn {
    // Properties (Fields)
    private final String checkInId;
    private final Passenger passenger;
    private final Flight flight;
    private Seat assignedSeat;
    private final List<Baggage> checkedBaggage;
    private boolean verifiedDocuments;

    // Constructor
    public CheckIn(String checkInId, Passenger passenger, Flight flight) {
        this.checkInId = checkInId;
        this.passenger = passenger;
        this.flight = flight;
        this.checkedBaggage = new ArrayList<>();
        this.verifiedDocuments = false;
    }

    // Methods
    public void verifyDocuments() {
        this.verifiedDocuments = true;
        System.out.println("Documents verified for Passenger " + passenger.getLastName() + ".");
    }

    public void assignSeat(Seat seat) {
        if (seat != null) {
            this.assignedSeat = seat;
            System.out.println("Seat " + seat.getSeatNumber() + " assigned for check-in " + this.checkInId + ".");
        } else {
            System.out.println("Seat assignment failed: Seat object is null.");
        }
    }

    public BoardingPass generateBoardingPass() {
        if (!isClearedForBoarding()) {
            System.err.println("Cannot generate pass: Documents not verified or seat not assigned.");
            return null;
        }
        String passNumber = this.flight.getFlightNumber() + "-" + this.assignedSeat.getSeatNumber() + "-" + this.checkInId;
        BoardingPass pass = new BoardingPass(passNumber, this.flight, this.passenger, this.assignedSeat);
        System.out.println("Boarding Pass generated: " + passNumber);
        return pass;
    }

    public void addBaggage(Baggage baggage) {
        if (baggage != null) {
            this.checkedBaggage.add(baggage);
            System.out.println("Baggage ID " + baggage.getBaggageId() + " added to check-in record.");
        }
    }

    public boolean isClearedForBoarding() {
        return this.verifiedDocuments && (this.assignedSeat != null);
    }

    // Getters
    public String getCheckInId() {
        return checkInId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getAssignedSeat() {
        return assignedSeat;
    }

    public List<Baggage> getCheckedBaggage() {
        return Collections.unmodifiableList(checkedBaggage);
    }

    public boolean isVerifiedDocuments() {
        return verifiedDocuments;
    }
}
