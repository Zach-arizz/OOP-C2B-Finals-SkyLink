import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmergencySystem {
    // Properties (Fields)
    private final String systemId;
    private final Flight flight;
    private boolean emergencyDeclared;
    private EmergencyType emergencyType;
    private final List<EmergencyResponseAction> actionsTaken;
    private Date declaredAt;
    private Date terminatedAt;

    // Constructor
    public EmergencySystem(String systemId, Flight flight) {
        this.systemId = systemId;
        this.flight = flight;
        this.emergencyDeclared = false;
        this.actionsTaken = new ArrayList<>();
    }

    // Methods
    public void declareEmergency(EmergencyType type, String details) {
        if (!this.emergencyDeclared) {
            this.emergencyDeclared = true;
            this.emergencyType = type;
            this.declaredAt = new Date();

            String declarationAction = "Emergency declared: " + type.name() + " (" + details + ")";
            logAction(new EmergencyResponseAction("SYSTEM", declarationAction, this.declaredAt));

            System.out.println("--- EMERGENCY DECLARED: " + type.name() + " for system " + systemId + " ---");
        } else {
            System.out.println("Emergency already active: " + this.emergencyType.name());
        }
    }

    public void notifyRescueServices(Airport airport) {
        if (this.emergencyDeclared) {
            String airportName = (airport != null) ? "Airport " + airport.hashCode() : "Nearest Airport";
            logAction(new EmergencyResponseAction("SYSTEM", "Notifying rescue services at " + airportName, new Date()));
        }
    }

    public void coordinateWithATCForPriority(AirTrafficController atc, String ops) {
        if (this.emergencyDeclared) {
            String atcId = (atc != null) ? "ATC " + atc.hashCode() : "TOWER";
            logAction(new EmergencyResponseAction(atcId, "Requested priority landing/vectoring.", new Date()));
        }
    }

    public void logAction(EmergencyResponseAction action) {
        if (action != null) {
            this.actionsTaken.add(action);
        }
    }

    public void terminateEmergency() {
        if (this.emergencyDeclared) {
            this.emergencyDeclared = false;
            this.terminatedAt = new Date();

            String terminationAction = "Emergency terminated successfully.";
            logAction(new EmergencyResponseAction("SYSTEM", terminationAction, this.terminatedAt));
            System.out.println("--- EMERGENCY TERMINATED for system " + systemId + " ---");
        }
    }

    public EmergencyReport generatePostEventReport() {
        if (this.declaredAt == null || this.terminatedAt == null || this.emergencyType == null) {
            System.err.println("Cannot generate report: Emergency was not properly declared or terminated.");
            return null;
        }

        long durationMs = this.terminatedAt.getTime() - this.declaredAt.getTime();
        long durationMinutes = TimeUnit.MILLISECONDS.toMinutes(durationMs);

        String summary = this.actionsTaken.size() > 5 ? "High level of intervention required." : "Resolved quickly.";

        EmergencyReport report = new EmergencyReport(
                "EPR-" + System.currentTimeMillis(),
                new Date(),
                systemId,
                this.emergencyType.name(),
                durationMinutes,
                new ArrayList<>(this.actionsTaken),
                summary
        );
        System.out.println("Post-Event Report " + report.reportId() + " generated.");
        return report;
    }

    // Getters
    public String getSystemId() {
        return systemId;
    }

    public Object getFlight() {
        return flight;
    }

    public boolean isEmergencyDeclared() {
        return emergencyDeclared;
    }

    public EmergencyType getEmergencyType() {
        return emergencyType;
    }

    public List<EmergencyResponseAction> getActionsTaken() {
        return actionsTaken;
    }

    public Date getDeclaredAt() {
        return declaredAt;
    }
}

