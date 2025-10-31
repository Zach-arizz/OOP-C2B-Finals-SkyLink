import java.util.List;
import java.util.ArrayList;

public class BaggageClaim {
    private String claimAreaId;
    private List<Baggage> baggageQueue;
    private boolean operational;
    private String assignedTerminal;

    public BaggageClaim(String claimAreaId, boolean operational, String assignedTerminal) {
        this.claimAreaId = claimAreaId;
        this.baggageQueue = new ArrayList<>();
        this.operational = operational;
        this.assignedTerminal = assignedTerminal;
    }

    public Baggage retrieveBaggage(String tagNumber) {
        return null;
    }

    public void addBaggageToCarousel(Baggage baggage) {
        this.baggageQueue.add(baggage);
    }

    public void notifyPassenger(Passenger passenger) {
    }

    public void reportMissingBag(String tagNumber) {
    }

    public void shutdownArea() {
        this.operational = false;
    }

    public String getClaimAreaId() {
        return claimAreaId;
    }


    public List<Baggage> getBaggageQueue() {
        return baggageQueue;
    }

    public boolean isOperational() {
        return operational;
    }

    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    public String getAssignedTerminal() {
        return assignedTerminal;
    }

    public void setAssignedTerminal(String assignedTerminal) {
        this.assignedTerminal = assignedTerminal;
    }
}