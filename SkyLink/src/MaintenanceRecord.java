import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class MaintenanceRecord {
    // Properties (Fields)
    private final String recordId;
    private final Date inspectionDate;
    private final String engineerName;

    private final List<String> issuesFound;
    private boolean isResolved;
    private String resolutionDetails;

    // Constructor
    public MaintenanceRecord(String recordId, Date inspectionDate, String engineerName) {
        if (recordId == null || recordId.trim().isEmpty()) {
            throw new IllegalArgumentException("Record ID cannot be null or empty.");
        }
        if (inspectionDate == null) {
            throw new IllegalArgumentException("Inspection date cannot be null.");
        }
        if (engineerName == null || engineerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Engineer name cannot be null or empty.");
        }

        this.recordId = recordId.trim();
        this.inspectionDate = inspectionDate;
        this.engineerName = engineerName.trim();

        this.issuesFound = new ArrayList<>();
        this.isResolved = false;
        this.resolutionDetails = "Pending Resolution";
    }

    // Methods
    public void addIssue(String issue) {
        if (issue != null && !issue.trim().isEmpty()) {
            this.issuesFound.add(issue.trim());
            System.out.println("Added issue to record " + this.recordId + ": " + issue);
        } else {
            System.err.println("Cannot add an empty issue to the record.");
        }
    }

    public void markResolved(String details) {
        if (this.isResolved) {
            System.out.println("Record " + this.recordId + " is already marked resolved.");
            return;
        }
        if (details != null && !details.trim().isEmpty()) {
            this.isResolved = true;
            this.resolutionDetails = details.trim();
            System.out.println("Record " + this.recordId + " marked resolved. Details: " + this.resolutionDetails);
        } else {
            System.err.println("Resolution details cannot be empty when marking as resolved.");
        }
    }

    public String getRecordSummary() {
        return "Record " + recordId + " | Date: " + inspectionDate + " | Resolved: " + isResolved + " | Issues Found: " + issuesFound.size();
    }

    // Getters and Setters
    public String getRecordId() {
        return recordId;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public List<String> getIssuesFound() {
        return Collections.unmodifiableList(this.issuesFound);
    }

    public boolean isResolved() {
        return this.isResolved;
    }

    public String getResolutionDetails() {
        return this.resolutionDetails;
    }
}