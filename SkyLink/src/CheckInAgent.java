import java.util.List;
import java.util.ArrayList;

class BoardingPass {}
class Seat{}
class BaggageTag {}

public class CheckInAgent extends Person {
    private int counterNumber;
    private String terminalSection;
    private List<String> acceptedDocuments;
    private boolean canIssueBoardingPass;

    public CheckInAgent (long id, String firstName, String lastName, String contactNumber, String email, String address, int counterNumber, String terminalSection) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.counterNumber = counterNumber;
        this.terminalSection = terminalSection;
        this.acceptedDocuments = new ArrayList<>();
        this.canIssueBoardingPass = true;
    }

    public CheckIn processCheckIn(Passenger passenger, Flight flight, List<Baggage> bags) {
        System.out.println("Processing Check-In...");
        return new CheckIn();
    }

    public BoardingPass issueBoardingPass(Passenger passenger, Flight flight, Seat assignedSeat) {
        System.out.println("Issuing Boarding Pass...");
        return new BoardingPass();
    }

    public BaggageTag printBaggageTag(Baggage baggage, Passenger passenger) {
        System.out.println("Printing Baggage Tag...");
        return new BaggageTag();
    }

    public boolean validateTravelDocuments(Passenger passenger) {
        System.out.println("Validating Travel Documents...");
        return true;
    }

    public void handleOversoldSituations(Flight flight) {
        System.out.println("Handling Oversold Situations...");
    }

    public void escalateCustomerIssue(String issueDetails) {
        System.out.println("Escalating Customer Issue...");
    }

    public int getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(int counterNumber) {
        this.counterNumber = counterNumber;
    }

    public String getTerminalSection() {
        return terminalSection;
    }

    public void setTerminalSection(String terminalSection) {
        this.terminalSection = terminalSection;
    }

    public List<String> getAcceptedDocuments() {
        return acceptedDocuments;
    }

    public void addAcceptedDocument(String document) {
        acceptedDocuments.add(document);
    }

    public boolean canIssueBoardingPass() {
        return canIssueBoardingPass;
    }

    public void setCanIssueBoardingPass(boolean canIssueBoardingPass) {
        this.canIssueBoardingPass = canIssueBoardingPass;
    }
}