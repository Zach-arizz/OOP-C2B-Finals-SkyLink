// FINALIZED
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Weather {
    // Properties (Fields)
    private String location;
    private Date observationTime;
    private double temperatureC;
    private double windSpeedKts;
    private double windDirectionDeg;
    private double visibilityKm;
    private String condition;
    private List<String> warnings;

    // Constructor
    public Weather(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty.");
        }

        this.location = location.trim();
        this.warnings = new ArrayList<>();
        this.observationTime = new Date();
        this.temperatureC = 15.0;
        this.windSpeedKts = 5.0;
        this.windDirectionDeg = 0.0;
        this.visibilityKm = 10.0;
        this.condition = "CLEAR";
    }

    // Methods
    public WeatherObservation getLatestObservation() {
        return new WeatherObservation(
                this.location,
                this.temperatureC,
                this.windSpeedKts,
                this.windDirectionDeg,
                this.visibilityKm,
                this.condition,
                Collections.unmodifiableList(new ArrayList<>(this.warnings))
        );
    }

    public void updateObservation(WeatherObservation obs) {
        if (obs == null) {
            System.err.println("Cannot update with a null observation.");
            return;
        }
        this.observationTime = obs.getObservationTime();
        this.temperatureC = obs.getTemperatureC();
        this.windSpeedKts = obs.getWindSpeedKts();
        this.windDirectionDeg = obs.getWindDirectionDeg();
        this.visibilityKm = obs.getVisibilityKm();
        this.condition = obs.getCondition();
        this.warnings = new ArrayList<>(obs.getWarnings());

        System.out.println("Weather observation updated for " + location + " at " + obs.getObservationTime());
    }

    public boolean isSevereForAircraft(Aircraft aircraft) {
        return visibilityKm < 1.0 || windSpeedKts > 40.0;
    }

    public String summarizeForFlightPlan() {
        return String.format("%s: %s, %.1fC, Wind %.1f kts, Vis %.1f km.",
                location, condition, temperatureC, windSpeedKts, visibilityKm);
    }

    public void subscribeUpdates(Flight flight) {
        if (flight == null) {
            System.err.println("Cannot subscribe null flight.");
            return;
        }
        System.out.println("Flight subscribed to weather updates for " + location);
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.err.println("Location cannot be set to null or empty.");
            return;
        }
        this.location = location.trim();
    }

    public Date getObservationTime() {
        return observationTime;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public double getWindSpeedKts() {
        return windSpeedKts;
    }

    public double getWindDirectionDeg() {
        return windDirectionDeg;
    }

    public double getVisibilityKm() {
        return visibilityKm;
    }

    public String getCondition() {
        return condition;
    }

    public List<String> getActiveWarnings() {
        return Collections.unmodifiableList(warnings);
    }
}