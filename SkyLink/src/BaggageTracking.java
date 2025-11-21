import java.util.Collections;

public class BaggageTracking {
    // Properties (Fields)
    private final String trackingId;
    private final Baggage baggage;
    private String currentLocation;

    // Constructor
    public BaggageTracking(String trackingId, Baggage baggage) {
        if (trackingId == null || trackingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Tracking ID cannot be null or empty.");
        }
        if (baggage == null) {
            throw new IllegalArgumentException("Baggage object must be provided.");
        }

        this.trackingId = trackingId.trim();
        this.baggage = baggage;
        this.currentLocation = "Check-in";
    }

    // Methods
    public void updateLocation(String newLocation, BaggageStatus status) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            System.err.println("New location cannot be null or empty.");
            return;
        }
        if (status == null) {
            System.err.println("Baggage status cannot be null.");
            return;
        }

        this.currentLocation = newLocation.trim();
        this.baggage.updateStatus(status);
        System.out.println("Tracking ID " + trackingId + " updated to: " + newLocation + " (" + status + ")");
    }

    public String getStatus() {
        return "Baggage " + baggage.getBaggageId() + " is at " + currentLocation;
    }

    // Getters and Setters
    public String getTrackingId() {
        return trackingId;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        if (currentLocation == null || currentLocation.trim().isEmpty()) {
            System.err.println("Current location cannot be set to null or empty.");
            return;
        }
        this.currentLocation = currentLocation.trim();
    }
}