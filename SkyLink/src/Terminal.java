import java.util.List;
import java.util.ArrayList;

public class Terminal {
    private String terminalId;
    private List<Gate> gates;
    private List<String> facilities;
    private boolean internationalSupport;

    public Terminal(String terminalId, boolean internationalSupport) {
        this.terminalId = terminalId;
        this.gates = new ArrayList<>();
        this.facilities = new ArrayList<>();
        this.internationalSupport = internationalSupport;
    }

    public void addGate(Gate gate) {
        this.gates.add(gate);
        System.out.println("Gate added");
    }

    public Gate findAvailableGate() {
        System.out.println("Finding available Gate...");
        return null;
    }

    public void updateFacility(String facility) {
        if (!this.facilities.contains(facility)) {
            this.facilities.add(facility);
        }
    }

    public void assignPassengersToGate(Flight flight, Gate gate) {
        System.out.println("Assigning passengers to flight...");
    }

    public void broadcastAnnouncement(String message) {
        System.out.println("Broadcasting announcement...");
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public boolean isInternationalSupport() {
        return internationalSupport;
    }

    public void setInternationalSupport(boolean internationalSupport) {
        this.internationalSupport = internationalSupport;
    }
}
