// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FlightDeck {
    // Properties (Fields)
    private final Pilot pilot;
    private final Copilot coPilot;
    private final List<String> avionicsSystems;
    private boolean cockpitSecured;

    // Constructor
    public FlightDeck(Pilot pilot, Copilot coPilot) {
        if (pilot == null || coPilot == null) {
            throw new IllegalArgumentException("Flight Deck must be initialized with both a Pilot and a Co-pilot.");
        }
        this.pilot = pilot;
        this.coPilot = coPilot;

        this.avionicsSystems = new ArrayList<>();
        this.avionicsSystems.add("Flight Management System (FMS)");
        this.avionicsSystems.add("Air Data Inertial Reference Unit (ADIRU)");
        this.avionicsSystems.add("AutoPilot System");

        this.cockpitSecured = false;

        System.out.println("Flight Deck initialized with Captain " + pilot.getLastName() + " and Co-Pilot " + coPilot.getLastName());
    }

    // Methods
    public boolean checkAvionicsSystem() {
        System.out.println("Avionics check initiated. Systems online: " + avionicsSystems.size());
        return avionicsSystems.contains("Flight Management System (FMS)");
    }

    public boolean secureCockpit() {
        if (!this.cockpitSecured) {
            this.cockpitSecured = true;
            System.out.println("Cockpit secured successfully. Access restricted.");
            return true;
        } else {
            System.out.println("Cockpit is already secured.");
            return false;
        }
    }

    public boolean openForAccess() {
        if (this.cockpitSecured) {
            this.cockpitSecured = false;
            System.out.println("Cockpit door temporarily unsecured to grant access.");
            return true;
        } else {
            System.out.println("Cockpit is already open/unsecured.");
            return false;
        }
    }

    // Getters and Setters
    public Pilot getPilot() {
        return this.pilot;
    }

    public Copilot getCoPilot() {
        return this.coPilot;
    }

    public List<String> getAvionicsSystems() {
        return Collections.unmodifiableList(this.avionicsSystems);
    }

    public boolean isCockpitSecured() {
        return this.cockpitSecured;
    }
}