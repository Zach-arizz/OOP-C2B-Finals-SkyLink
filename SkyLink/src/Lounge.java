import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Lounge {
    // Properties (Fields)
    private final String loungeId;
    private int capacity;
    private final List<Passenger> currentGuests;
    private final List<String> amenities;
    private boolean isPremiumAccess;

    // Constructor
    public Lounge(String loungeId, int capacity, boolean isPremiumAccess) {
        if (loungeId == null || loungeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Lounge ID cannot be null or empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Lounge capacity must be positive.");
        }
        this.loungeId = loungeId.trim();
        this.capacity = capacity;
        this.isPremiumAccess = isPremiumAccess;
        this.currentGuests = new ArrayList<>();
        this.amenities = new ArrayList<>();
    }

    // Methods
    public boolean admitPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot admit a null passenger.");
            return false;
        }
        if (isFull()) {
            System.out.println("Lounge " + loungeId + " is currently at full capacity (" + this.capacity + ").");
            return false;
        }
        this.currentGuests.add(passenger);
        System.out.println("Passenger " + passenger.getId() + " admitted to Lounge " + loungeId);
        return true;
    }

    public void removePassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot remove a null passenger.");
            return;
        }
        if (this.currentGuests.remove(passenger)) {
            System.out.println("Passenger " + passenger.getId() + " departed Lounge " + loungeId);
        } else {
            System.out.println("Passenger " + passenger.getId() + " was not found in Lounge " + loungeId);
        }
    }

    public void serveRefreshments() {
        if (this.currentGuests.isEmpty()) {
            System.out.println("No guests currently in Lounge " + loungeId + " to serve.");
            return;
        }
        System.out.println("Refreshments served to " + this.currentGuests.size() + " guests in Lounge " + loungeId);
    }

    public void manageSeatingArrangement() {
        System.out.println("Seating optimized for " + this.currentGuests.size() + " guests.");
    }

    public boolean isFull() {
        return this.currentGuests.size() >= this.capacity;
    }

    public void updateAmenities(List<String> newAmenities) {
        if (newAmenities != null) {
            // Clears existing and adds new ones to the final list
            this.amenities.clear();
            this.amenities.addAll(newAmenities);
            System.out.println("Lounge " + loungeId + " amenities updated. Total count: " + this.amenities.size());
        } else {
            System.err.println("Cannot update amenities with a null list.");
        }
    }

    // Getters and Setters
    public String getLoungeId() {
        return loungeId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.err.println("Lounge capacity must be set to a positive value.");
        }
    }

    public List<Passenger> getCurrentGuests() {
        return Collections.unmodifiableList(currentGuests);
    }

    public void setCurrentGuests(List<Passenger> currentGuests) {
        if (currentGuests != null) {
            // Clears existing and adds new ones to the final list
            this.currentGuests.clear();
            this.currentGuests.addAll(currentGuests);
        } else {
            System.err.println("Cannot set current guests with a null list.");
        }
    }

    public List<String> getAmenities() {
        return Collections.unmodifiableList(amenities);
    }

    public void setAmenities(List<String> amenities) {
        if (amenities != null) {
            // Clears existing and adds new ones to the final list
            this.amenities.clear();
            this.amenities.addAll(amenities);
        } else {
            System.err.println("Cannot set amenities list to null.");
        }
    }

    public boolean isPremiumAccess() {
        return isPremiumAccess;
    }

    public void setPremiumAccess(boolean isPremiumAccess) {
        this.isPremiumAccess = isPremiumAccess;
    }
}