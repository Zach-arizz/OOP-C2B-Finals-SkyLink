// FINALIZED
public class BaggageTag {
    // Properties (Fields)
    private final String tagNumber;
    private final Passenger linkedPassenger;
    private final Flight linkedFlight;
    private String destinationCode;

    // Constructor
    public BaggageTag(String tagNumber, Passenger linkedPassenger, Flight linkedFlight, String destinationCode) {
        this.tagNumber = tagNumber;
        this.linkedPassenger = linkedPassenger;
        this.linkedFlight = linkedFlight;
        this.destinationCode = destinationCode;
    }

    // Methods
    public void printTagDetails() {
        System.out.println("--- PRINTING BAGGAGE TAG ---");
        System.out.println("Tag: " + tagNumber + " | Dest: " + destinationCode);
        System.out.println("Flight: " + linkedFlight.getFlightNumber() + " | Owner: " + linkedPassenger.getLastName());
        System.out.println("----------------------------");
    }

    public String getTagInfo() {
        return "Tag#" + tagNumber + " for " + linkedFlight.getFlightNumber() + " going to " + destinationCode;
    }

    public void updateDestination(String newDestinationCode) {
        System.out.println("Updating tag " + tagNumber + ": Destination changed from " + destinationCode + " to " + newDestinationCode);
        this.destinationCode = newDestinationCode;
    }

    // Getters
    public String getTagNumber() {
        return tagNumber;
    }

    public Passenger getLinkedPassenger() {
        return linkedPassenger;
    }

    public Flight getLinkedFlight() {
        return linkedFlight;
    }

    public String getDestinationCode() {
        return destinationCode;
    }
}
