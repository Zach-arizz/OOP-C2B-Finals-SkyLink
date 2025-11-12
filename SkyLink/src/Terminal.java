import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Terminal {
    // Properties (Fields)
    private final String terminalId;
    private List<Gate> gates;
    private final List<String> facilities;
    private boolean internationalSupport;

    // Constructor
    public Terminal(String terminalId, boolean internationalSupport) {
        if (terminalId == null || terminalId.trim().isEmpty()) {
            throw new IllegalArgumentException("Terminal ID cannot be null or empty.");
        }

        this.terminalId = terminalId.trim();
        this.internationalSupport = internationalSupport;
        this.gates = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    // Methods
    public void addGate(Gate gate) {
        if (gate != null) {
            this.gates.add(gate);
        }
    }

    public Gate findAvailableGate() {
        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                return gate;
            }
        }
        return null;
    }

    public void updateFacility(String facility) {
        if (facility != null && !facility.trim().isEmpty() && !this.facilities.contains(facility.trim())) {
            this.facilities.add(facility.trim());
            System.out.println("Facility " + facility + " added to Terminal " + terminalId);
        }
    }

    public void assignPassengersToGate(Flight flight, Gate gate, List<Passenger> passengerList) {
        if (flight == null || gate == null || passengerList == null) {
            System.err.println("Cannot assign passengers: one or more inputs are null.");
            return;
        }

        if (this.gates.contains(gate)) {
            gate.setCurrentFlight(flight);
            System.out.println("Assigned " + passengerList.size() + " passengers for flight " + flight.getFlightNumber() + " to Gate " + gate.getGateNumber());
        } else {
            System.out.println("Error: Gate " + gate.getGateNumber() + " is not part of Terminal " + terminalId);
        }
    }

    public void broadcastAnnouncement(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.err.println("Cannot broadcast an empty message.");
            return;
        }
        System.out.println("[Terminal " + terminalId + " Broadcast]: " + message);
    }

    // Getters and Setters
    public String getTerminalId() {
        return terminalId;
    }

    public List<Gate> getGates() {
        return Collections.unmodifiableList(gates);
    }

    public void setGates(List<Gate> gates) {
        if (gates == null) {
            this.gates = new ArrayList<>();
            return;
        }
        this.gates = new ArrayList<>(gates);
    }

    public List<String> getFacilities() {
        return Collections.unmodifiableList(facilities);
    }

    public boolean isInternationalSupport() {
        return internationalSupport;
    }

    public void setInternationalSupport(boolean internationalSupport) {
        this.internationalSupport = internationalSupport;
    }
}