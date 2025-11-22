// FINALIZED
import java.util.List;
import java.util.ArrayList;

public class Baggage {
    // Properties (Fields)
    private final String baggageId;
    private final double weightKg;
    private final Passenger owner;
    private BaggageTag tag;
    private BaggageStatus status;

    // Constructor
    public Baggage(String baggageId, double weightKg, Passenger owner) {
        this.baggageId = baggageId;
        this.weightKg = weightKg;
        this.owner = owner;
        this.tag = null;
        this.status = BaggageStatus.PENDING_CHECKIN;
    }

    // Methods
    public void attachTag(BaggageTag tag) {
        if (tag != null) {
            this.tag = tag;
            System.out.println("Baggage " + baggageId + " tag attached: " + tag.getTagNumber());
            updateStatus(BaggageStatus.CHECKED_IN);
        }
    }

    public void updateStatus(BaggageStatus newStatus) {
        if (newStatus != null) {
            System.out.println("Baggage " + baggageId + " status updated from " + this.status + " to " + newStatus);
            this.status = newStatus;
        }
    }

    public String getTrackingDetails() {
        String tagId = (this.tag != null) ? this.tag.getTagNumber() : "N/A";
        return "ID: " + baggageId + " | Owner: " + owner.getLastName() + " | Status: " + status + " | Tag: " + tagId;
    }

    public boolean isOverweight(double limit) {
        return this.weightKg > limit;
    }

    // Getters
    public String getBaggageId() {
        return baggageId;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public Passenger getOwner() {
        return owner;
    }

    public BaggageTag getTag() {
        return tag;
    }

    public BaggageStatus getStatus() {
        return status;
    }
}
