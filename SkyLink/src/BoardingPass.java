// FINALIZED
import java.util.Date;

public class BoardingPass {
    // Properties (Fields)
    private final String passNumber;
    private final Flight flight;
    private final Passenger passenger;
    private final Seat seat;
    private final Date issueTime;
    private Gate boardingGate;
    private boolean isScanned;

    // Constructor
    public BoardingPass(String passNumber, Flight flight, Passenger passenger, Seat seat) {
        this.passNumber = passNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.issueTime = new Date();
        this.isScanned = false;
    }

    // Methods
    public void validateAtGate() {
        if (flight == null) {
            System.out.println("Validation failed: Flight information is missing.");
            return;
        }

        if (flight.getStatus() == FlightStatus.BOARDING && this.boardingGate != null) {
            this.isScanned = true;
            System.out.println("Boarding Pass " + this.passNumber + " validated at gate " + this.boardingGate.getGateNumber() + ".");
            return;
        }

        System.out.println("Boarding Pass validation failed. Gate closed or flight not boarding (" + flight.getStatus().name() + ").");
        this.isScanned = false;
    }

    public void updateGate(Gate gate) {
        if (gate != null) {
            this.boardingGate = gate;
            System.out.println("Boarding Pass updated. New gate: " + gate.getGateNumber() + ".");
        }
    }

    public void printPass() {
        System.out.println("Printing Boarding Pass " + this.passNumber + " for " + passenger.getLastName() + ".");
    }

    public String getBoardingDetails() {
        return String.format("Flight: %s, Gate: %s, Seat: %s, Passenger: %s",
                flight.getFlightNumber(),
                (boardingGate != null ? boardingGate.getGateNumber() : "TBD"),
                seat.getSeatNumber(),
                passenger.getLastName());
    }

    // Getters
    public String getPassNumber() {
        return passNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public Gate getBoardingGate() {
        return boardingGate;
    }

    public Date getIssueTime() {
        return (Date) issueTime.clone();
    }

    public boolean isScanned() {
        return isScanned;
    }
}
