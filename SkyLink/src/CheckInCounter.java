// FINALIZED
public class CheckInCounter {
    // Properties (Fields)
    private final int counterNumber;
    private CheckInAgent agent;
    private boolean isOpen;

    // Constructor
    public CheckInCounter(int counterNumber) {
        if (counterNumber <= 0) {
            throw new IllegalArgumentException("Counter number must be positive.");
        }

        this.counterNumber = counterNumber;
        this.isOpen = false;
        this.agent = null;
    }

    // Methods
    public void openCounter() {
        if (!this.isOpen) {
            this.isOpen = true;
            System.out.println("Check-in Counter " + this.counterNumber + " is now open.");
        }
    }

    public void closeCounter() {
        if (this.isOpen) {
            this.isOpen = false;
            System.out.println("Check-in Counter " + this.counterNumber + " is now closed.");
        }
    }

    public void assignAgent(CheckInAgent agent) {
        if (agent == null) {
            System.err.println("Cannot assign null agent to counter " + this.counterNumber);
            return;
        }
        this.agent = agent;
        System.out.println("Agent assigned to Counter " + this.counterNumber + ".");
    }

    public void removeAgent() {
        this.agent = null;
        System.out.println("Agent removed from Counter " + this.counterNumber + ".");
    }

    // Getters and Setters
    public int getCounterNumber() {
        return counterNumber;
    }

    public CheckInAgent getAgent() {
        return agent;
    }

    public void setAgent(CheckInAgent agent) {
        this.agent = agent;
    }

    public boolean isCounterOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}