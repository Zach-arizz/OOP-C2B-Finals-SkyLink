import java.util.List;
import java.util.ArrayList;

class Weather{}

public class Airport {
    private String airportCode;
    private String name;
    private String location;
    private List<Terminal> terminals;
    private List<Runway> runways;
    private List<Gate> gates;
    private Weather currentWeather;

    public Airport(String airportCode, String name, String location, Weather currentWeather) {
        this.airportCode = airportCode;
        this.name = name;
        this.location = location;
        this.terminals = new ArrayList<>();
        this.runways = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.currentWeather = null;
    }

    public void addTerminal(Terminal terminal) {
        this.terminals.add(terminal);
        System.out.println("Terminal added");
    }

    public void addRunway(Runway runway) {
        this.runways.add(runway);
        System.out.println("Runway added");
    }

    public Gate assignGateToFlight(Flight flight) {
        System.out.println("Assigning gate to flight");
        return null;
    }

    public void updateWeather(Weather weather) {
        this.currentWeather = weather;
        System.out.println("Weather updated");
    }

    public Terminal getTerminalById(String terminalId) {
        System.out.println("Searching for terminal with id...");
        return null;
    }

    public void generateAirportReport() {
        System.out.println("Generating airport report");
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public Weather getCurrentWeather() {
        return currentWeather;
    }
}