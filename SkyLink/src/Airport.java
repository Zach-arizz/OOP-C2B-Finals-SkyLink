import java.util.Collections;
import java.util.List;

public class Airport {
    // Properties (Fields)
    private final String airportCode;
    private final String name;
    private final String location;
    private final double latitude;
    private final double longitude;
    private final List<Terminal> terminals;
    private final List<Runway> runways;
    private final List<Gate> gates;
    private final Weather currentWeather;

    // Constructor
    public Airport(String airportCode, String name, String location, double latitude, double longitude) {
        if (airportCode == null || airportCode.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport code and name cannot be null or empty.");
        }
        this.airportCode = airportCode;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.terminals = new java.util.ArrayList<>();
        this.runways = new java.util.ArrayList<>();
        this.gates = new java.util.ArrayList<>();
        this.currentWeather = new Weather(location);
    }

    // Methods
    public void addTerminal(Terminal terminal) {
        if (terminal != null) {
            this.terminals.add(terminal);
        }
    }

    public void addRunway(Runway runway) {
        if (runway != null) {
            this.runways.add(runway);
        }
    }

    public Gate assignGateToFlight(Flight flight) {
        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                gate.setCurrentFlight(flight);
                System.out.println("Flight " + flight.getFlightNumber() + " assigned to Gate " + gate.getGateNumber());
                return gate;
            }
        }
        System.out.println("No gates currently available.");
        return null;
    }

    public void updateWeather(WeatherObservation newObservation) {
        this.currentWeather.updateObservation(newObservation);
        System.out.println("Airport weather updated: " + this.currentWeather.getCondition());
        if (this.currentWeather.isSevereForAircraft(null)) {
            System.out.println("CRITICAL: Severe weather alert! Conditions: " + this.currentWeather.getCondition());
        }
    }

    public Terminal getTerminalById(String terminalId) {
        for (Terminal terminal : terminals) {
            if (terminal.getTerminalId().equals(terminalId)) {
                return terminal;
            }
        }
        return null;
    }

    public void generateAirportReport() {
        System.out.println("Generating operational report for " + this.name + " (" + this.airportCode + ")");
        System.out.println("Current Weather Summary: " + this.currentWeather.summarizeForFlightPlan());
    }

    public Waypoint toWaypoint() {
        return new Waypoint(this.airportCode, this.latitude, this.longitude, "Airport");
    }

    // Getters and Setters
    public String getAirportCode() {
        return airportCode;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<Terminal> getTerminals() {
        return Collections.unmodifiableList(terminals);
    }

    public List<Runway> getRunways() {
        return Collections.unmodifiableList(runways);
    }

    public List<Gate> getGates() {
        return Collections.unmodifiableList(gates);
    }

    public Weather getCurrentWeather() {
        return currentWeather;
    }
}