import java.util.Collections;

public class BoardingGate extends Gate {
    // Properties (Fields)
    private SecurityOfficer gateSecurity;

    // Constructor
    public BoardingGate(String gateNumber, boolean hasJetBridge, SecurityOfficer officer) {
        super(gateNumber, hasJetBridge);
        if (officer == null) {
            System.err.println("Warning: BoardingGate initialized without a SecurityOfficer.");
        }
        this.gateSecurity = officer;
    }

    // Methods
    public boolean scanBoardingPass(BoardingPass pass) {
        if (pass == null) {
            System.err.println("Cannot scan null boarding pass.");
            return false;
        }

        System.out.println("Scanning pass...");
        return pass.validateAtGate();
    }

    public void announceBoardingGroup(String group) {
        if (group == null || group.trim().isEmpty()) {
            System.err.println("Cannot announce null or empty boarding group.");
            return;
        }
        System.out.println("Now boarding group: " + group.trim());
    }

    public boolean isGateOpen() {
        return getStatus() == GateStatus.AVAILABLE || getStatus() == GateStatus.BOARDING;
    }

    public void updateGateStatus(GateStatus status) {
        if (status == null) {
            System.err.println("Cannot update gate status to null.");
            return;
        }

        if (status == GateStatus.AVAILABLE || status == GateStatus.BOARDING) {
            openGate();
        } else if (status == GateStatus.CLOSED) {
            closeGate();
        } else {
            System.out.println("Gate status updated to: " + status);
        }
    }

    // Getters and Setters
    public SecurityOfficer getGateSecurity() {
        return gateSecurity;
    }

    public void setGateSecurity(SecurityOfficer gateSecurity) {
        this.gateSecurity = gateSecurity;
    }
}