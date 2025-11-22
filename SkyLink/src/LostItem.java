// FINALIZED
import java.util.Date;

public class LostItem {
    // Properties (Fields)
    private final String itemId;
    private final String description;
    private final String locationFound;
    private final Date dateFound;
    private LostItemReport associatedReport;
    private ItemStatus status;

    // Constructor
    public LostItem(String itemId, String description, String locationFound) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be null or empty.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (locationFound == null || locationFound.trim().isEmpty()) {
            throw new IllegalArgumentException("Location found cannot be null or empty.");
        }

        this.itemId = itemId.trim();
        this.description = description.trim();
        this.locationFound = locationFound.trim();
        this.dateFound = new Date();
        // NOTE: Assuming ItemStatus enum exists
        this.status = ItemStatus.FOUND;
        this.associatedReport = null;
    }

    // Methods
    public void updateStatus(ItemStatus newStatus) {
        if (newStatus == null) {
            System.err.println("Cannot update status to null.");
            return;
        }
        this.status = newStatus;
        System.out.println("Item " + itemId + " status updated to: " + newStatus);
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public Date getDateFound() {
        return dateFound;
    }

    public LostItemReport getAssociatedReport() {
        return associatedReport;
    }

    public void setAssociatedReport(LostItemReport associatedReport) {
        this.associatedReport = associatedReport;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.updateStatus(status);
    }
}