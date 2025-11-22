// FINALIZED
import java.util.Date;

public class LostItemReport {
    // Properties (Fields)
    private final String reportId;
    private final Passenger reporter;
    private final String itemDescription;
    private final Date dateReported;
    private String lastSeenLocation;
    private LostItem matchedItem;

    // Constructor
    public LostItemReport(Passenger reporter, String itemDescription) {
        if (reporter == null) {
            throw new IllegalArgumentException("Reporter (Passenger) must be provided.");
        }
        if (itemDescription == null || itemDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Item description cannot be null or empty.");
        }
        this.reportId = "RPT-" + reporter.getId() + "-" + System.currentTimeMillis();
        this.reporter = reporter;
        this.itemDescription = itemDescription.trim();
        this.dateReported = new Date();
        this.lastSeenLocation = "Unknown";
        this.matchedItem = null;
    }

    // Methods
    public void markAsMatched(LostItem item) {
        if (item == null) {
            System.err.println("Cannot match report to null item.");
            return;
        }
        this.matchedItem = item;
        item.setAssociatedReport(this);
        item.updateStatus(ItemStatus.CLAIMED);
        System.out.println("Report " + reportId + " matched to item " + item.getItemId());
    }

    public boolean isResolved() {
        return this.matchedItem != null;
    }

    // Getters and Setters
    public String getReportId() {
        return reportId;
    }

    public Passenger getReporter() {
        return reporter;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public void setLastSeenLocation(String lastSeenLocation) {
        if (lastSeenLocation == null || lastSeenLocation.trim().isEmpty()) {
            System.err.println("Location cannot be null or empty.");
            return;
        }
        this.lastSeenLocation = lastSeenLocation.trim();
    }

    public LostItem getMatchedItem() {
        return matchedItem;
    }
}