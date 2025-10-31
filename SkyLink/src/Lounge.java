import java.util.List;
import java.util.ArrayList;

public class Lounge {
    private String loungeId;
    private int capacity;
    private List<Passenger> currentGuests;
    private List<String> amenities;
    public boolean isPremiumAccess;

    public Lounge(String loungeId, int capacity, boolean isPremiumAccess) {
        this.loungeId = loungeId;
        this.capacity = capacity;
        this.currentGuests = new ArrayList<>();
        this.amenities = new ArrayList<>();
        this.isPremiumAccess = isPremiumAccess;
    }

    public boolean admitPassenger(Passenger passenger) {
        if (this.currentGuests.size() < this.capacity) {
            this.currentGuests.add(passenger);
            return true;
        }
        return false;
    }

    public void removePassenger(Passenger passenger) {
        this.currentGuests.remove(passenger);
    }

    public void serveRefreshments() {
    }

    public void manageSeatingArrangement () {
    }

    public boolean isFull() {
        return this.currentGuests.size() >= this.capacity;
    }

    public void updateAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public String getLoungeId() {
        return loungeId;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> getCurrentGuests() {
        return currentGuests;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public boolean isPremiumAccess() {
        return isPremiumAccess;
    }

    public void setPremiumAccess(boolean isPremiumAccess) {
        this.isPremiumAccess = isPremiumAccess;
    }
}