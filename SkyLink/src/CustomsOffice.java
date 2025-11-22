// FINALIZED
import java.util.List;
import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;

public class CustomsOffice {
    // Properties (Fields)
    private final String officeId;
    private List<Passenger> queuedPassengers;
    private List<CustomsDeclaration> declarations;
    private boolean immigrationOfficerAvailable;
    private static final double DUTY_RATE = 0.15; // 15% duty rate

    // Constructor
    public CustomsOffice(String officeId) {
        this.officeId = officeId;
        this.queuedPassengers = new ArrayList<>();
        this.declarations = new ArrayList<>();
        this.immigrationOfficerAvailable = true;
    }

    // Methods
    public boolean processPassenger(Passenger passenger, Document travelDocs) {
        if (!immigrationOfficerAvailable) {
            System.out.println("Processing failed: No immigration officer available at " + officeId);
            return false;
        }
        System.out.println("Processing passenger " + passenger.getId() + " with documents at " + officeId + ". Status: Under Review.");
        return true;
    }

    public boolean verifyDeclaration(CustomsDeclaration declaration) {
        this.declarations.add(declaration);

        if (declaration.isHighRisk()) {
            System.out.println("Verifying declaration " + declaration.getDeclarationId() + ". Status: **HIGH RISK**, requires inspection.");
            return false;
        }
        System.out.println("Verifying declaration " + declaration.getDeclarationId() + ". Status: Accepted.");
        return true;
    }

    public double collectDuties(CustomsDeclaration declaration) {
        double dutiableValue = declaration.calculateDutiableValue();
        double duty = dutiableValue * DUTY_RATE;

        System.out.println("Calculated duties of PHP" + String.format("%.2f", duty) + " (Rate: " + (DUTY_RATE * 100) + "%) for declaration " + declaration.getDeclarationId());
        return duty;
    }

    public void confiscateProhibitedItems(List<String> items) {
        if (items != null && !items.isEmpty()) {
            System.out.println("Confiscating " + items.size() + " prohibited items at " + officeId + ": " + items);
        } else {
            System.out.println("No prohibited items to confiscate.");
        }
    }

    public void releasePassenger(Passenger passenger) {
        if (this.queuedPassengers.remove(passenger)) {
            System.out.println("Passenger " + passenger.getId() + " successfully cleared customs and released.");
        } else {
            System.out.println("Error: Passenger " + passenger.getId() + " was not in the queue.");
        }
    }

    // Getters and Setters
    public String getOfficeId() {
        return officeId;
    }

    public List<Passenger> getQueuedPassengers() {
        return Collections.unmodifiableList(queuedPassengers);
    }

    public void setQueuedPassengers(List<Passenger> queuedPassengers) {
        this.queuedPassengers = new ArrayList<>(queuedPassengers);
    }

    public List<CustomsDeclaration> getDeclarations() {
        return Collections.unmodifiableList(declarations);
    }

    public void setDeclarations(List<CustomsDeclaration> declarations) {
        this.declarations = new ArrayList<>(declarations);
    }

    public boolean isImmigrationOfficerAvailable() {
        return immigrationOfficerAvailable;
    }

    public void setImmigrationOfficerAvailable(boolean immigrationOfficerAvailable) {
        this.immigrationOfficerAvailable = immigrationOfficerAvailable;
    }
}
