// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BaggageClaim {
    // Properties (Fields)
    private final String claimAreaId;
    private final List<Baggage> baggageQueue;
    private boolean operational;
    private String assignedTerminal;
    private String assignedFlightNumber;

    // Constructor
    public BaggageClaim(String claimAreaId, String assignedTerminal) {
        this.claimAreaId = claimAreaId;
        this.assignedTerminal = assignedTerminal;
        this.baggageQueue = new ArrayList<>();
        this.operational = true;
        this.assignedFlightNumber = "UNASSIGNED";
    }

    // Methods
    public Baggage retrieveBaggage(String tagNumber) {
        Baggage retrievedBag = null;
        for (Baggage bag : baggageQueue) {
            if (bag.getTag() != null && bag.getTag().getTagNumber().equals(tagNumber)) {
                retrievedBag = bag;
                break;
            }
        }

        if (retrievedBag != null) {
            this.baggageQueue.remove(retrievedBag);
            System.out.println("Baggage " + tagNumber + " successfully retrieved from area " + claimAreaId);
            return retrievedBag;
        }
        System.out.println("Baggage " + tagNumber + " not found in area " + claimAreaId);
        return null;
    }

    public void addBaggageToCarousel(Baggage baggage) {
        if (this.operational && baggage != null) {
            String bagTagNum = (baggage.getTag() != null) ? baggage.getTag().getTagNumber() : "UNTAGGED";
            this.baggageQueue.add(baggage);
            System.out.println("Baggage " + bagTagNum + " added to carousel " + claimAreaId);
        } else {
            System.out.println("Cannot add baggage; Claim Area is not operational.");
        }
    }

    public void assignFlight(String flightNumber, String terminal) {
        this.assignedFlightNumber = flightNumber;
        this.assignedTerminal = terminal;
        System.out.println("Claim Area " + claimAreaId + " assigned to Flight " + flightNumber + " in Terminal " + terminal);
    }

    public void shutdownArea() {
        this.operational = false;
        System.out.println("Baggage Claim Area " + claimAreaId + " shut down.");
    }

    public void activateArea() {
        this.operational = true;
        System.out.println("Baggage Claim Area " + claimAreaId + " activated.");
    }

    public void notifyPassenger(Passenger passenger) {
        System.out.println("Notification sent to " + passenger.getLastName() + " regarding baggage on carousel " + claimAreaId);
    }

    public void reportMissingBag(String tagNumber) {
        System.out.println("Missing bag report initiated for tag: " + tagNumber);
    }

    // Getters
    public String getClaimAreaId() {
        return claimAreaId;
    }

    public List<Baggage> getBaggageQueue() {
        return Collections.unmodifiableList(baggageQueue);
    }

    public boolean isOperational() {
        return operational;
    }

    public String getAssignedTerminal() {
        return assignedTerminal;
    }

    public String getAssignedFlightNumber() {
        return assignedFlightNumber;
    }
}
