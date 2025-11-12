import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CheckInAgent extends Person {
    // Properties (Fields)
    private final int counterNumber;
    private String terminalSection;
    private final List<String> acceptedDocuments;
    private boolean canIssueBoardingPass;

    // Constructor
    public CheckInAgent(long id, String firstName, String lastName, String contactNumber, String email, String address,
                        int counterNumber, String terminalSection) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.counterNumber = counterNumber;
        this.terminalSection = terminalSection;
        this.acceptedDocuments = new ArrayList<>();
        this.canIssueBoardingPass = true;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Check-In Agent (Counter: " + this.counterNumber + ", ID: " + this.getId() + ")";
    }

    public Object processCheckIn(Passenger passenger, Flight flight, List<Baggage> bags) {
        System.out.println("Processing check-in for Passenger ID " + passenger.getId() + " at counter " + this.counterNumber + ".");
        return null;
    }

    public Object issueBoardingPass(Passenger passenger, Flight flight, Seat assignedSeat) {
        System.out.println("Issuing boarding pass to " + passenger.getLastName() + " for seat " + assignedSeat.getSeatNumber() + ".");
        return null;
    }

    public Object printBaggageTag(Baggage baggage, Passenger passenger) {
        System.out.println("Printing tag for baggage " + baggage.getBaggageId() + " belonging to " + passenger.getLastName() + ".");
        return null;
    }

    public boolean validateTravelDocuments(Passenger passenger) {
        System.out.println("Validating travel documents for Passenger ID " + passenger.getId() + ".");
        return true;
    }

    public void handleOversoldSituations(Flight flight) {
        System.out.println("Handling oversold situation for Flight " + flight.getFlightNumber() + ".");
    }

    public void escalateCustomerIssue(String issueDetails) {
        System.out.println("Escalating customer issue: " + issueDetails);
    }

    // Getters and Setters
    public int getCounterNumber() {
        return counterNumber;
    }

    public String getTerminalSection() {
        return terminalSection;
    }

    public void setTerminalSection(String terminalSection) {
        this.terminalSection = terminalSection;
    }

    public List<String> getAcceptedDocuments() {
        return Collections.unmodifiableList(acceptedDocuments);
    }

    public void addAcceptedDocument(String document) {
        if (document != null && !document.trim().isEmpty() && !acceptedDocuments.contains(document)) {
            acceptedDocuments.add(document);
        }
    }

    public boolean canIssueBoardingPass() {
        return canIssueBoardingPass;
    }

    public void setCanIssueBoardingPass(boolean canIssueBoardingPass) {
        this.canIssueBoardingPass = canIssueBoardingPass;
    }
}
