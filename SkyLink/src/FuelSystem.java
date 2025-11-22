// FINALIZED
import java.util.List;
import java.util.ArrayList;

public class FuelSystem {
    // Properties (Fields)
    private final double fuelCapacity;
    private double currentFuelLevel;
    private FuelQuality fuelQuality;
    private final NavigationSystem navigationSystem;

    // Constructor
    public FuelSystem(double fuelCapacity, NavigationSystem navigationSystem) {
        if (navigationSystem == null) {
            throw new IllegalArgumentException("NavigationSystem dependency cannot be null.");
        }
        this.fuelCapacity = Math.max(0, fuelCapacity);
        this.currentFuelLevel = 0.0;
        this.fuelQuality = FuelQuality.NOMINAL;
        this.navigationSystem = navigationSystem;
    }

    // Methods
    public void refuel(double amount) {
        if (amount <= 0) {
            System.err.println("Refuel amount must be positive.");
            return;
        }

        double newLevel = this.currentFuelLevel + amount;
        if (newLevel > this.fuelCapacity) {
            System.out.println("Warning: Attempted to add " + amount + " units, but capacity is limited to " + this.fuelCapacity);
        }

        this.currentFuelLevel = Math.min(newLevel, this.fuelCapacity);
        System.out.println("Refueled " + amount + " units. Current level: " + this.currentFuelLevel);
    }

    public void consumeFuel(double amount) {
        if (amount <= 0) {
            System.err.println("Consumption amount must be positive.");
            return;
        }

        this.currentFuelLevel = Math.max(this.currentFuelLevel - amount, 0.0);
        System.out.println("Consumed " + amount + " units. Remaining: " + this.currentFuelLevel);

        if (this.currentFuelLevel == 0.0 && this.fuelCapacity > 0.0) {
            alertFuelExhausted();
        } else if (this.currentFuelLevel <= (this.fuelCapacity * 0.1) && this.fuelCapacity > 0.0) {
            alertLowFuel();
        }
    }

    public double getRemainingRange() {
        final double FUEL_EFFICIENCY_FACTOR = 0.5;
        return this.currentFuelLevel * FUEL_EFFICIENCY_FACTOR;
    }

    public boolean verifyFuelQuality() {
        return this.fuelQuality == FuelQuality.NOMINAL;
    }

    public void alertLowFuel() {
        String alertMsg = "CRITICAL LOW FUEL LEVEL (Current: " + this.currentFuelLevel + ")";
        System.err.println("!!! ALERT: " + alertMsg);

        this.navigationSystem.receiveCriticalAlert("FUEL_LOW", alertMsg);
    }

    public void alertFuelExhausted() {
        String alertMsg = "EMERGENCY: FUEL EXHAUSTED (Current: 0.0)";
        System.err.println("!!! EMERGENCY: " + alertMsg);

        this.navigationSystem.receiveCriticalAlert("FUEL_EXHAUSTED", alertMsg);
    }

    // Getters and Setters
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public FuelQuality getFuelQualityStatus() {
        return fuelQuality;
    }

    public void setFuelQualityStatus(FuelQuality fuelQuality) {
        if (fuelQuality != null) {
            this.fuelQuality = fuelQuality;
        } else {
            System.err.println("Cannot set fuel quality status to null.");
        }
    }
}