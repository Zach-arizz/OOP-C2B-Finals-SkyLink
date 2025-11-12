import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CargoHold {
    // Properties (Fields)
    private static final double AVERAGE_BAGGAGE_WEIGHT_KG = 20.0;
    private final double maxCapacityKg;
    private double currentLoadKg;
    private final List<Baggage> loadedBaggage;
    private final List<String> cargoItems;
    private boolean isSecure;

    //Constructor
    public CargoHold(double maxCapacityKg) {
        this.maxCapacityKg = maxCapacityKg;
        this.currentLoadKg = 0.0;
        this.loadedBaggage = new ArrayList<>();
        this.cargoItems = new ArrayList<>();
        this.isSecure = false;
    }

    // Methods
    public boolean loadBaggage(Baggage baggage) {
        if (checkWeightLimit(AVERAGE_BAGGAGE_WEIGHT_KG)) {
            this.loadedBaggage.add(baggage);
            this.currentLoadKg += AVERAGE_BAGGAGE_WEIGHT_KG;
            System.out.println("Baggage loaded. Current load: " + this.currentLoadKg + " kg.");
            return true;
        }
        System.out.println("Load failed. Max capacity reached.");
        return false;
    }

    public boolean unloadBaggage(Baggage baggage) {
        if (this.loadedBaggage.remove(baggage)) {
            this.currentLoadKg -= AVERAGE_BAGGAGE_WEIGHT_KG;
            System.out.println("Baggage unloaded. Current load: " + this.currentLoadKg + " kg.");
            return true;
        }
        return false;
    }

    public boolean checkWeightLimit(double addedWeight) {
        return (this.currentLoadKg + addedWeight) <= this.maxCapacityKg;
    }

    public void secureCargo() {
        this.isSecure = true;
        System.out.println("Cargo hold has been secured and locked.");
    }

    public double calculateRemainingCapacity() {
        return this.maxCapacityKg - this.currentLoadKg;
    }

    public boolean inspectContents(String officerId) {
        System.out.println("CargoHold inspection initiated by Officer " + officerId + ".");
        for (String item : cargoItems) {
            if (item.toLowerCase().contains("explosive") || item.toLowerCase().contains("toxic")) {
                this.isSecure = false;
                System.out.println("Inspection FAILED: Prohibited item found: " + item);
                return false;
            }
        }

        this.isSecure = true;
        System.out.println("CargoHold inspection PASSED. Status set to secure.");
        return true;
    }

    // Getters and Setters
    public double getMaxCapacityKg() {
        return maxCapacityKg;
    }

    public double getCurrentLoadKg() {
        return currentLoadKg;
    }

    public List<Baggage> getLoadedBaggage() {
        return Collections.unmodifiableList(loadedBaggage);
    }

    public List<String> getCargoItems() {
        return Collections.unmodifiableList(cargoItems);
    }

    public void addCargoItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            this.cargoItems.add(item);
        }
    }

    public void removeCargoItem(String item) {
        this.cargoItems.remove(item);
    }

    public boolean isSecure() {
        return isSecure;
    }
}
