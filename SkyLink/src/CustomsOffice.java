import java.util.List;
import java.util.ArrayList;

class CustomsDeclaration {}

public class CustomsOffice {
    private String officeId;
    private List<Passenger> queuedPassengers;
    private List<CustomsDeclaration> declarations;
    private boolean immigrationOfficerAvailable;

    public CustomsOffice(String officeId, boolean immigrationOfficerAvailable) {
        this.officeId = officeId;
        this.queuedPassengers = new ArrayList<>();
        this.declarations = new ArrayList<>();
        this.immigrationOfficerAvailable = immigrationOfficerAvailable;
    }

    public void processPassenger(Passenger passenger, Document travelDocs) {
        this.queuedPassengers.add(passenger);
    }

    public boolean verifyDeclarations(CustomsDeclaration declaration) {
        return true;
    }

    public void collectDuties(Passenger passenger, double amount) {
    }

    public void confiscateProhibitedItems(List<String> items) {
    }

    public void releasePassenger(Passenger passenger) {
        this.queuedPassengers.remove(passenger);
    }

    public String getOfficeId() {
        return officeId;
    }

    public List<Passenger> getQueuedPassengers() {
        return queuedPassengers;
    }

    public List<CustomsDeclaration> getDeclarations() {
        return declarations;
    }

    public boolean isImmigrationOfficerAvailable() {
        return immigrationOfficerAvailable;
    }

    public void setImmigrationOfficerAvailable(boolean immigrationOfficerAvailable) {
        this.immigrationOfficerAvailable = immigrationOfficerAvailable;
    }
}