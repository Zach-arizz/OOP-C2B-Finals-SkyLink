// FINALIZED
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class LostAndFound {
    // Properties (Fields)
    private final String officeId;
    private final List<LostItemReport> reportedItems;
    private final List<LostItem> storedItems;
    private final Map<String, Passenger> claimants;
    private int retentionDays;

    // Constructor
    public LostAndFound(String officeId, int retentionDays) {
        if (officeId == null || officeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Office ID cannot be null or empty.");
        }
        if (retentionDays <= 0) {
            throw new IllegalArgumentException("Retention days must be positive.");
        }

        this.officeId = officeId.trim();
        this.retentionDays = retentionDays;
        this.reportedItems = new ArrayList<>();
        this.storedItems = new ArrayList<>();
        this.claimants = new HashMap<>();
    }

    // Methods
    public LostItemReport fileLostItemReport(Passenger p, String description) {
        if (p == null || description == null || description.trim().isEmpty()) {
            System.err.println("Cannot file report: Passenger or description is invalid.");
            return null;
        }
        LostItemReport report = new LostItemReport(p, description);
        this.reportedItems.add(report);
        System.out.println("Lost Item Report filed by " + p.getFullName() + ".");
        return report;
    }

    public void registerFoundItem(LostItem item) {
        if (item == null) {
            System.err.println("Cannot register null item.");
            return;
        }
        this.storedItems.add(item);
        System.out.println("Found item registered: " + item.getDescription());
    }

    public boolean matchItemToClaimant(String itemId, Passenger claimant) {
        if (itemId == null || itemId.trim().isEmpty() || claimant == null) {
            System.err.println("Cannot match item: Item ID or claimant is invalid.");
            return false;
        }
        System.out.println("Attempting to match item " + itemId + " with claimant " + claimant.getFullName());
        return true;
    }

    public void returnItemToOwner(String itemId, Passenger owner) {
        if (itemId == null || itemId.trim().isEmpty() || owner == null) {
            System.err.println("Cannot return item: Item ID or owner is invalid.");
            return;
        }
        System.out.println("Item " + itemId + " returned to owner " + owner.getFullName() + ".");
    }

    public void disposeUnclaimedItem(String itemId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            System.err.println("Cannot dispose of item: Item ID is invalid.");
            return;
        }
        System.out.println("Disposing of unclaimed item: " + itemId);
    }

    public List<LostItem> searchItems(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.err.println("Search query cannot be empty.");
            return Collections.emptyList();
        }
        System.out.println("Searching for items matching: " + query);
        return Collections.unmodifiableList(storedItems);
    }

    // Getters and Setters
    public String getOfficeId() {
        return officeId;
    }

    public List<LostItemReport> getReportedItems() {
        return Collections.unmodifiableList(reportedItems);
    }

    public List<LostItem> getStoredItems() {
        return Collections.unmodifiableList(storedItems);
    }

    public Map<String, Passenger> getClaimants() {
        return Collections.unmodifiableMap(claimants);
    }

    public int getRetentionDays() {
        return retentionDays;
    }

    public void setRetentionDays(int retentionDays) {
        if (retentionDays <= 0) {
            System.err.println("Retention days must be positive.");
            return;
        }
        this.retentionDays = retentionDays;
    }
}
