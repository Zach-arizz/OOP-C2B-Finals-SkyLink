import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class WeatherObservation {
    // Properties (Fields)
    private final Date observationTime;
    private final String location;
    private final double temperatureC;
    private final double windSpeedKts;
    private final double windDirectionDeg;
    private final double visibilityKm;
    private final String condition;
    private final List<String> warnings;

    // Constructor
    public WeatherObservation(String location, double temp, double windSpeed, double windDirection, double visibility, String condition, List<String> warnings) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty.");
        }
        if (visibility < 0) {
            throw new IllegalArgumentException("Visibility cannot be negative.");
        }
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be null or empty.");
        }

        this.observationTime = new Date();
        this.location = location.trim();
        this.temperatureC = temp;
        this.windSpeedKts = windSpeed;
        this.windDirectionDeg = windDirection;
        this.visibilityKm = visibility;
        this.condition = condition.trim();

        // Simple defensive copy in the constructor
        this.warnings = (warnings != null) ? new ArrayList<>(warnings) : new ArrayList<>();
    }

    // Methods
    public String getObservationSummary() {
        return String.format("Obs at %s for %s: Temp %.1fC, Wind %.1f kts, Vis %.1f km. Cond: %s",
                observationTime, location, temperatureC, windSpeedKts, visibilityKm, condition);
    }

    // Getters and Setters
    public Date getObservationTime() {
        return observationTime;
    }

    public String getLocation() {
        return location;
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

    public List<String> getWarnings() {
        return Collections.unmodifiableList(warnings);
    }
}