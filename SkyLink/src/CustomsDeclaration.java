import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class CustomsDeclaration {

    // Properties (Fields)
    private final String declarationId;
    private final Passenger passenger;
    private final boolean isGoodsToDeclare;
    private double totalDeclaredValue;
    private final List<ItemDeclaration> declaredItems;
    private final Date dateFiled;
    private boolean isHighRisk;
    private DeclarationStatus status;

    // Philippine Rules Constants
    private static final double DUTY_FREE_ALLOWANCE_PHP = 10000.00;
    private static final double HIGH_RISK_VALUE_THRESHOLD_PHP = 50000.00;

    // Constructor
    public CustomsDeclaration(String declarationId, Passenger passenger, boolean isGoodsToDeclare) {
        this(declarationId, passenger, isGoodsToDeclare, new ArrayList<>());
    }

    // Primary Constructor
    public CustomsDeclaration(String declarationId, Passenger passenger, boolean isGoodsToDeclare, List<ItemDeclaration> initialItems) {
        this.declarationId = declarationId;
        this.passenger = passenger;
        this.isGoodsToDeclare = isGoodsToDeclare;
        this.declaredItems = new ArrayList<>();
        this.dateFiled = new Date();
        this.totalDeclaredValue = 0.0;
        this.status = DeclarationStatus.FILED;
        for (ItemDeclaration item : initialItems) {
            addItem(item.description(), item.value());
        }
        this.isHighRisk = updateRiskStatus();
    }

    // Methods
    public double calculateDutiableValue() {
        if (isGoodsToDeclare && this.totalDeclaredValue > DUTY_FREE_ALLOWANCE_PHP) {
            return this.totalDeclaredValue - DUTY_FREE_ALLOWANCE_PHP;
        }
        return 0.0;
    }

    public String getDutiableValueSummary() {
        double dutiableValue = calculateDutiableValue();
        if (dutiableValue > 0) {
            return String.format(
                    "Dutiable Value (PHP): %.2f (Total Value: %.2f - Allowance: %.2f)",
                    dutiableValue, this.totalDeclaredValue, DUTY_FREE_ALLOWANCE_PHP
            );
        }
        return "No dutiable value found (within duty-free allowance).";
    }

    public void addItem(String description, double value) {
        if (this.status != DeclarationStatus.FILED) {
            System.err.println("Error: Cannot add items. Declaration status is " + this.status + ".");
            return;
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Item description cannot be empty.");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Item value cannot be negative.");
        }

        this.declaredItems.add(new ItemDeclaration(description, value));
        this.totalDeclaredValue += value;
        this.isHighRisk = updateRiskStatus(); // Recalculate risk status immediately
        System.out.println("Added item: " + description + " (Value: PHP" + String.format("%.2f", value) + ")");
    }

    private boolean updateRiskStatus() {
        boolean riskStatus = this.totalDeclaredValue > HIGH_RISK_VALUE_THRESHOLD_PHP;
        if (riskStatus && !this.isHighRisk) {
            // Assumes Passenger.getId() exists.
            System.out.println("ALERT: Declaration flagged as High Risk for Passenger ID: " + passenger.getId());
        }
        return riskStatus;
    }

    public void processDeclaration() {
        if (this.status != DeclarationStatus.FILED) {
            System.out.println("Declaration " + declarationId + " is already being processed or is finalized (Status: " + this.status + ").");
            return;
        }

        this.status = DeclarationStatus.PROCESSING;
        System.out.println("Declaration " + declarationId + " moved to PROCESSING status.");

        if (this.isHighRisk) {
            this.status = DeclarationStatus.REVIEW_REQUIRED;
            System.out.println("Flagged: High Risk Declaration. Status set to REVIEW_REQUIRED.");
        } else if (calculateDutiableValue() > 0) {
            this.status = DeclarationStatus.DUTY_ASSESSED;
            System.out.println("Flagged: Dutiable items found. Status set to DUTY_ASSESSED.");
        } else {
            this.status = DeclarationStatus.CLEARED;
            System.out.println("Declaration " + declarationId + " successfully CLEARED.");
        }
    }

    public boolean submitDeclaration() {
        if (this.status == DeclarationStatus.FILED) {
            System.out.println("Declaration " + declarationId + " submitted by Passenger ID: " + passenger.getId());
            processDeclaration(); // Automatically process upon submission for this model
            return true;
        } else {
            System.out.println("Declaration " + declarationId + " cannot be submitted. Status: " + this.status);
            return false;
        }
    }

    // Getters
    public String getDeclarationId() {
        return declarationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public boolean isGoodsToDeclare() {
        return isGoodsToDeclare;
    }

    public double getTotalDeclaredValue() {
        return totalDeclaredValue;
    }

    public List<ItemDeclaration> getDeclaredItems() {
        return Collections.unmodifiableList(declaredItems);
    }

    public Date getDateFiled() {
        return (Date) dateFiled.clone();
    }

    public boolean isHighRisk() {
        return isHighRisk;
    }

    public DeclarationStatus getStatus() {
        return status;
    }
}
