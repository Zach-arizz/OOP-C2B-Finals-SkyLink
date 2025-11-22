// FINALIZED
static class UI {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static final String SEPARATOR_EQ = "==================================================================";
    public static final String SEPARATOR_DASH = "------------------------------------------------------------------";
    public static final String SEPARATOR_STAR = "******************************************************************";

    private static final int WIDTH = 66;

    public static void println(String text, String color) {
        IO.println(color + text + RESET);
    }

    public static void print(String text, String color) {
        IO.print(color + text + RESET);
    }

    // TYPEWRITER EFFECT
    public static void printTypewriter(String text, String color, int delayMs) {
        IO.print(color);
        for (char c : text.toCharArray()) {
            IO.print(c);
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        IO.println(RESET);
    }

    public static String center(String s) {
        if (s == null || WIDTH <= s.length()) {
            return s;
        }
        int padding = WIDTH - s.length();
        int leftPad = padding / 2;

        return " ".repeat(leftPad) + s;
    }

    public static void header(String title) {
        String prefix = ">>> ";

        IO.println("\n" + CYAN + SEPARATOR_EQ + RESET);

        String fullTitle = prefix + title;
        String paddedTitle = center(fullTitle);
        printTypewriter(paddedTitle, WHITE_BOLD, 15);

        IO.println(CYAN + SEPARATOR_EQ + RESET);
    }
}

void main() {
    Scanner scanner = new Scanner(System.in);

    // MAIN BANNER
    UI.println(UI.SEPARATOR_EQ, UI.CYAN);
    String bannerTitle = "SKYLINK AIRWAYS: GLOBAL INTERACTIVE SYSTEM";
    String centeredBanner = UI.center(bannerTitle);
    UI.printTypewriter(centeredBanner, UI.YELLOW, 5);
    UI.println(UI.SEPARATOR_EQ, UI.CYAN);

    // ---------------------------------------------------------
    // STEP 1: INFRASTRUCTURE SETUP
    // ---------------------------------------------------------
    Airport mnl = new Airport("MNL", "Ninoy Aquino Intl", "Manila, PH", 14.5086, 121.0194);

    Airport nrt = new Airport("NRT", "Narita International", "Tokyo, Japan", 35.7719, 140.3928);
    Airport sin = new Airport("SIN", "Changi Airport", "Singapore", 1.3644, 103.9915);
    Airport lax = new Airport("LAX", "Los Angeles Intl", "California, USA", 33.9416, -118.4085);
    Airport lhr = new Airport("LHR", "Heathrow Airport", "London, UK", 51.4700, -0.4543);
    Airport syd = new Airport("SYD", "Kingsford Smith", "Sydney, Australia", -33.9399, 151.1753);
    Airport dxb = new Airport("DXB", "Dubai International", "Dubai, UAE", 25.2532, 55.3657);
    Airport icn = new Airport("ICN", "Incheon International", "Seoul, South Korea", 37.4602, 126.4407);
    Airport hkg = new Airport("HKG", "Hong Kong Intl", "Hong Kong", 22.3080, 113.9185);
    Airport bkk = new Airport("BKK", "Suvarnabhumi Airport", "Bangkok, Thailand", 13.6900, 100.7501);
    Airport yvr = new Airport("YVR", "Vancouver International", "Vancouver, Canada", 49.1967, -123.1762);
    Airport cdg = new Airport("CDG", "Charles de Gaulle", "Paris, France", 49.0097, 2.5479);
    Airport fco = new Airport("FCO", "Leonardo da Vinci", "Rome, Italy", 41.7999, 12.2462);

    SecurityOfficer gateOfficer = new SecurityOfficer(999, "Gate", "Guard", "N/A", "N/A", "N/A", "Gate 134");
    Terminal term3 = new Terminal("NAIA-T3", true);
    BoardingGate gate134 = new BoardingGate("134", true, gateOfficer);
    Runway rwy06 = new Runway("06/24", 3737.0);
    term3.addGate(gate134);
    mnl.addTerminal(term3);
    mnl.addRunway(rwy06);

    // ---------------------------------------------------------
    // STEP 2: CHOOSE DESTINATION
    // ---------------------------------------------------------
    UI.header("[1] FLIGHT SELECTION");
    UI.println("Where would you like to fly today?", UI.WHITE_BOLD);
    UI.println(UI.SEPARATOR_DASH, UI.CYAN);
    UI.println(" [1] Tokyo, Japan (NRT)        [7] Seoul, South Korea (ICN)", UI.CYAN);
    UI.println(" [2] Singapore (SIN)           [8] Hong Kong (HKG)", UI.CYAN);
    UI.println(" [3] Los Angeles, USA (LAX)    [9] Bangkok, Thailand (BKK)", UI.CYAN);
    UI.println(" [4] London, UK (LHR)         [10] Vancouver, Canada (YVR)", UI.CYAN);
    UI.println(" [5] Sydney, Australia (SYD)  [11] Paris, France (CDG)", UI.CYAN);
    UI.println(" [6] Dubai, UAE (DXB)         [12] Rome, Italy (FCO)", UI.CYAN);
    UI.println(UI.SEPARATOR_DASH, UI.CYAN);

    int destChoice;
    // INPUT HANDLER: Destination Choice (1-12, numeric only)
    do {
        UI.print("Enter choice (1-12): ", UI.WHITE_BOLD);
        if (scanner.hasNextInt()) {
            destChoice = scanner.nextInt();
            scanner.nextLine();
            if (destChoice >= 1 && destChoice <= 12) {
                break;
            } else {
                UI.println("Invalid choice. Please enter a number between 1 and 12.", UI.RED);
            }
        } else {
            UI.println("Invalid input. Please enter a number.", UI.RED);
            scanner.nextLine();
        }
    } while (true);
    // END INPUT HANDLER

    Airport dest;
    String flightNum;
    double ticketPrice;

    switch (destChoice) {
        case 2 -> {
            dest = sin;
            flightNum = "PR507";
            ticketPrice = 15000.0;
        }
        case 3 -> {
            dest = lax;
            flightNum = "PR102";
            ticketPrice = 65000.0;
        }
        case 4 -> {
            dest = lhr;
            flightNum = "PR720";
            ticketPrice = 70000.0;
        }
        case 5 -> {
            dest = syd;
            flightNum = "PR211";
            ticketPrice = 45000.0;
        }
        case 6 -> {
            dest = dxb;
            flightNum = "PR658";
            ticketPrice = 40000.0;
        }
        case 7 -> {
            dest = icn;
            flightNum = "PR468";
            ticketPrice = 22000.0;
        }
        case 8 -> {
            dest = hkg;
            flightNum = "PR306";
            ticketPrice = 12000.0;
        }
        case 9 -> {
            dest = bkk;
            flightNum = "PR730";
            ticketPrice = 14000.0;
        }
        case 10 -> {
            dest = yvr;
            flightNum = "PR116";
            ticketPrice = 68000.0;
        }
        case 11 -> {
            dest = cdg;
            flightNum = "PR010";
            ticketPrice = 72000.0;
        }
        case 12 -> {
            dest = fco;
            flightNum = "PR012";
            ticketPrice = 75000.0;
        }
        default -> {
            dest = nrt;
            flightNum = "PR428";
            ticketPrice = 25000.0;
        }
    }
    UI.println(String.format("Destination selected: %s (%s)", dest.getLocation(), dest.getAirportCode()), UI.YELLOW);


    // ---------------------------------------------------------
    // STEP 3: PASSENGER DETAILS & MEAL
    // ---------------------------------------------------------
    UI.header("[2] PASSENGER INFO");

    String name;
    // INPUT HANDLER: Name
    do {
        UI.print("Full Name: ", UI.WHITE_BOLD);
        name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            UI.println("Name cannot be empty.", UI.RED);
        } else if (name.matches("[0-9]+")) {
            UI.println("Invalid name. Please enter your name (not just numbers).", UI.RED);
        }
    } while (name.isEmpty() || name.matches("[0-9]+"));
    // END INPUT HANDLER

    String ppt;
    // INPUT HANDLER: Passport Number
    do {
        UI.print("Passport Number: ", UI.WHITE_BOLD);
        ppt = scanner.nextLine().trim();

        if (ppt.isEmpty()) {
            UI.println("Passport Number cannot be empty.", UI.RED);
        } else if (ppt.length() < 7 || ppt.length() > 12) {
            UI.println("Invalid length. Passport numbers are typically 7 to 12 characters long.", UI.RED);
        } else if (!ppt.matches("^[a-zA-Z0-9]+$")) {
            UI.println("Invalid format. Passport number should only contain letters and digits (A-Z, 0-9).", UI.RED);
        } else {
            break; // Validation passed
        }
    } while (true);
    // END INPUT HANDLER

    String fName = name.split(" ")[0];
    String lName = name.contains(" ") ? name.substring(name.indexOf(" ") + 1) : "";

    Passenger user = new Passenger(101, fName, lName, "0917-XXX", "email@test.com", "Manila", ppt, "Filipino");

    UI.header("[3] IN-FLIGHT MEAL SELECTION");
    UI.println("[1] Chicken Adobo", UI.CYAN);
    UI.println("[2] Beef Caldereta", UI.CYAN);
    UI.println("[3] Vegetarian Lasagna", UI.CYAN);
    UI.println("[4] Seafood Kare-Kare", UI.CYAN);

    int mealChoice;
    // INPUT HANDLER: Meal Choice (1-4, numeric only)
    do {
        UI.print("Choose your meal (1-4): ", UI.WHITE_BOLD);
        if (scanner.hasNextInt()) {
            mealChoice = scanner.nextInt();
            scanner.nextLine();
            if (mealChoice >= 1 && mealChoice <= 4) {
                break;
            } else {
                UI.println("Invalid choice. Please enter a number between 1 and 4.", UI.RED);
            }
        } else {
            UI.println("Invalid input. Please enter a number.", UI.RED);
            scanner.nextLine();
        }
    } while (true);
    // END INPUT HANDLER

    String selectedMeal = switch (mealChoice) {
        case 2 -> "Beef Caldereta";
        case 3 -> "Vegetarian Lasagna";
        case 4 -> "Seafood Kare-Kare";
        default -> "Chicken Adobo";
    };
    UI.println("Meal confirmed: " + selectedMeal, UI.GREEN);

    // ---------------------------------------------------------
    // STEP 4: FLIGHT PREP
    // ---------------------------------------------------------
    UI.header("FLIGHT PREPARATION (Pre-flight checks)");
    NavigationSystem nav = new NavigationSystem("14.5, 121.0", 0, 0);
    Aircraft plane = new Aircraft("RP-C3501", "Airbus A350", 300, nav, new FuelSystem(180000, nav));
    plane.addEngine(new Engine("E1", "RR", 90000));
    plane.performPreFlightInspection();

    Flight flight = new Flight(flightNum, mnl, dest);
    flight.setSchedule(new Schedule(new Date(), LocalTime.now(), LocalTime.now().plusHours(4)));
    flight.assignAircraft(plane);

    if (gate134.isAvailable()) gate134.setCurrentFlight(flight);
    flight.calculateDistance();

    // ---------------------------------------------------------
    // STEP 5: PAYMENT METHOD SELECTION
    // ---------------------------------------------------------
    UI.header("[4] PAYMENT");
    Booking booking = new Booking("BK-001", user, flight);
    booking.assignSeat(new Seat("14A", SeatClass.ECONOMY));
    System.out.printf("Base Ticket Price: %sPHP %,.2f%s%n", UI.YELLOW, ticketPrice, UI.RESET);

    UI.println("Select Payment Method:", UI.WHITE_BOLD);
    UI.println("[1] Credit Card", UI.CYAN);
    UI.println("[2] Debit Card", UI.CYAN);
    UI.println("[3] Bank Transfer (BDO/BPI)", UI.CYAN);

    int payChoice;
    // INPUT HANDLER: Payment Choice (1-3, numeric only)
    do {
        UI.print("Enter choice (1-3): ", UI.WHITE_BOLD);
        if (scanner.hasNextInt()) {
            payChoice = scanner.nextInt();
            scanner.nextLine();
            if (payChoice >= 1 && payChoice <= 3) {
                break;
            } else {
                UI.println("Invalid choice. Please enter a number between 1 and 3.", UI.RED);
            }
        } else {
            UI.println("Invalid input. Please enter a number.", UI.RED);
            scanner.nextLine();
        }
    } while (true);
    // END INPUT HANDLER

    PaymentMethod method;
    switch (payChoice) {
        case 2 -> method = new DebitCard("12345", "BPI", 900000.0);
        case 3 -> method = new BankTransfer("BDO", "123-456", "BDO-PH");
        default -> method = new CreditCard("4500123412341234", name, "12/30", "123", 1000000.0);
    }

    Payment pay = new Payment("TXN-001", booking, ticketPrice);
    if (pay.processPayment(method)) {
        booking.confirmBooking();
        booking.generateTicket();
    } else {
        UI.println("Payment Failed. Exiting Simulation.", UI.RED);
        scanner.close();
        return;
    }

    // ---------------------------------------------------------
    // STEP 6: CHECK-IN & BAGGAGE WEIGHT
    // ---------------------------------------------------------
    UI.header("[5] CHECK-IN & BAGGAGE");
    CheckIn checkIn = new CheckIn("CI-001", user, flight);
    checkIn.assignSeat(new Seat("14A", SeatClass.ECONOMY));
    checkIn.verifyDocuments();

    String bagYes;
    // INPUT HANDLER: Baggage Yes/No
    do {
        UI.print("Do you have baggage to check? (Y/N): ", UI.WHITE_BOLD);
        bagYes = scanner.nextLine().trim().toUpperCase();
        if (bagYes.equals("Y") || bagYes.equals("N")) {
            break;
        } else {
            UI.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.", UI.RED);
        }
    } while (true);
    // END INPUT HANDLER

    double baggageFee = 0.0;
    double bagWeight = 0.0;

    if (bagYes.equals("Y")) {
        // INPUT HANDLER: Baggage Weight
        do {
            UI.print("Enter baggage weight (kg): ", UI.WHITE_BOLD);
            if (scanner.hasNextDouble()) {
                bagWeight = scanner.nextDouble();
                scanner.nextLine();
                if (bagWeight >= 0) {
                    break;
                } else {
                    UI.println("Invalid weight. Please enter a non-negative number.", UI.RED);
                }
            } else {
                UI.println("Invalid input. Please enter a number.", UI.RED);
                scanner.nextLine();
            }
        } while (true);
        // END INPUT HANDLER

        Baggage bag = new Baggage("BAG-01", bagWeight, user);

        if (bag.isOverweight(23.0)) {
            UI.println("!! WARNING !! Bag is overweight (>23kg). Heavy tag applied.", UI.RED);
            baggageFee = 2500.00;
            UI.println("Overweight Fee: PHP 2,500.00 charged.", UI.RED);
        }
        bag.attachTag(new BaggageTag("TAG-001", user, flight, dest.getAirportCode()));
        checkIn.addBaggage(bag);
    } else {
        UI.println("No checked baggage.", UI.YELLOW);
    }

    BoardingPass bp = checkIn.generateBoardingPass();
    UI.println("Boarding Pass generated.", UI.GREEN);

    // ---------------------------------------------------------
    // STEP 7: FLIGHT EXPERIENCE (Boarding)
    // ---------------------------------------------------------
    UI.header("[6] BOARDING & FLIGHT");

    flight.updateStatus(FlightStatus.BOARDING);

    gate134.startBoarding(flight);
    gate134.scanBoardingPass(bp);
    flight.boardPassenger(user);
    gate134.endBoarding();

    UI.printTypewriter("... Taking off from MNL ...", UI.YELLOW, 10);
    flight.updateStatus(FlightStatus.IN_FLIGHT);
    UI.printTypewriter("... Cruising Altitude ...", UI.YELLOW, 10);

    FlightAttendant fa = new FlightAttendant(501, "Nancy", "B", "0917", "fa@ph", "Mnl", 5);
    UI.println("Flight Attendant " + fa.getFirstName() + " is approaching.", UI.CYAN);
    fa.serveMeals(user);
    UI.println("SERVED: " + selectedMeal, UI.GREEN);

    UI.printTypewriter("... Beginning descent ...", UI.YELLOW, 10);
    UI.printTypewriter("... Landing at " + dest.getLocation() + " ...", UI.YELLOW, 10);
    flight.updateStatus(FlightStatus.ARRIVED);

    // ---------------------------------------------------------
    // STEP 8: CUSTOMS DECLARATION
    // ---------------------------------------------------------
    UI.header("[7] CUSTOMS DECLARATION");
    UI.println("Welcome to " + dest.getAirportCode() + ".", UI.WHITE_BOLD);

    CustomsDeclaration customForm = new CustomsDeclaration("CD-001", user, true);

    while (true) {
        String add;
        // INPUT HANDLER: Customs Item Yes/No
        do {
            UI.print("Add item to declare? (Y/N): ", UI.WHITE_BOLD);
            add = scanner.nextLine().trim().toUpperCase();
            if (add.equals("Y") || add.equals("N")) {
                break;
            } else {
                UI.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.", UI.RED);
            }
        } while (true);
        // END INPUT HANDLER

        if (add.equals("N")) break;

        UI.print("Item Description: ", UI.WHITE_BOLD);
        String desc = scanner.nextLine();

        double val;
        // INPUT HANDLER: Item Value
        do {
            UI.print("Value (PHP): ", UI.WHITE_BOLD);
            if (scanner.hasNextDouble()) {
                val = scanner.nextDouble();
                scanner.nextLine();
                if (val >= 0) {
                    break;
                } else {
                    UI.println("Invalid value. Please enter a non-negative number.", UI.RED);
                }
            } else {
                UI.println("Invalid input. Please enter a number.", UI.RED);
                scanner.nextLine();
            }
        } while (true);
        // END INPUT HANDLER

        customForm.addItem(desc, val);
    }
    customForm.submitDeclaration();

    // ---------------------------------------------------------
    // STEP 9: FEEDBACK
    // ---------------------------------------------------------
    UI.header("[8] FEEDBACK");

    int rating;
    // INPUT HANDLER: Rating (1-5, numeric only)
    do {
        UI.print("Rate your flight (1-5): ", UI.WHITE_BOLD);
        if (scanner.hasNextInt()) {
            rating = scanner.nextInt();
            scanner.nextLine();
            if (rating >= 1 && rating <= 5) {
                break;
            } else {
                UI.println("Invalid rating. Please enter a number between 1 and 5.", UI.RED);
            }
        } else {
            UI.println("Invalid input. Please enter a number.", UI.RED);
            scanner.nextLine();
        }
    } while (true);
    // END INPUT HANDLER

    UI.print("Comments: ", UI.WHITE_BOLD);
    String comment = scanner.nextLine();

    Feedback fb = new Feedback("FB-001", user, rating, comment);
    UI.println("Feedback recorded: " + fb.summarizeFeedback(), UI.GREEN);

    // ---------------------------------------------------------
    // STEP 10: INVOICE GENERATION
    // ---------------------------------------------------------
    IO.println("\n\n");
    UI.println(UI.SEPARATOR_STAR, UI.PURPLE);
    String invoiceTitle = "OFFICIAL E-INVOICE";
    IO.println(UI.center(invoiceTitle));
    UI.println(UI.SEPARATOR_STAR, UI.PURPLE);
    UI.println(" Transaction ID : TXN-" + System.currentTimeMillis(), UI.CYAN);
    UI.println(" Date           : " + new Date(), UI.CYAN);
    UI.println(UI.SEPARATOR_DASH, UI.PURPLE);
    System.out.printf(" PASSENGER      : %s %s\n", UI.WHITE_BOLD + fName.toUpperCase(), lName.toUpperCase() + UI.RESET);
    System.out.printf(" FLIGHT         : %s (MNL -> %s)\n", flightNum, dest.getAirportCode());
    IO.print(" SEAT           : 14A (Economy)\n");
    System.out.printf(" MEAL           : %s\n", selectedMeal);
    UI.println(UI.SEPARATOR_DASH, UI.PURPLE);
    System.out.printf(" Ticket Base Fare           : PHP %,10.2f\n", ticketPrice);

    if (baggageFee > 0) {
        System.out.printf(UI.RED + " Excess Baggage Fee (%.1fkg): PHP %,10.2f\n" + UI.RESET, bagWeight, baggageFee);
    } else {
        System.out.printf(" Baggage Fee (%.1fkg)       : PHP       0.00\n", bagWeight);
    }

    double tax = (ticketPrice + baggageFee) * 0.12;
    System.out.printf(" VAT (12%%)                  : PHP %,10.2f\n", tax);
    UI.println(UI.SEPARATOR_DASH, UI.PURPLE);
    double grandTotal = ticketPrice + baggageFee + tax;
    System.out.printf(UI.GREEN + " GRAND TOTAL                : PHP %,10.2f\n" + UI.RESET, grandTotal);
    UI.println(UI.SEPARATOR_STAR, UI.PURPLE);

    String thanksMessage = "Thank you for flying SkyLink Airways!";
    String centeredThanks = UI.center(thanksMessage);
    UI.printTypewriter(centeredThanks, UI.WHITE_BOLD, 5);
    UI.println(UI.SEPARATOR_STAR, UI.PURPLE);

    scanner.close();
}