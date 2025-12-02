# SkyLink Flight Management System ✈️

#Members: Templo, Niño Adrian R. Templo (SAKAMOTO) 

## Purpose

---
SkyLink Flight Management System is a sophisticated airline platform designed to automate the process of air travel, from the initial booking and check-in processes to complex flight operations and essential post-flight services. Our system centrally manages all aspects of air travel, ensuring a seamless experience for passengers and providing staff (including Pilots, Cabin Crew, and Air Traffic Controllers) with the tools necessary for efficient, safe, and regulated operations. By integrating Aircraft Management, robust Payment Systems, and various Airport Structures, SkyLink delivers a modern, end-to-end solution for the demands of global aviation.

---
## Key Features
---

### 1. Booking and Reservation Management
- **Automated Flight Booking:** Passengers can reserve `Flights` and select `Seats` (Economy, Business, First) via the `ReservationSystem`.
- **Ticketing and Confirmation:** Generates `Tickets` upon confirmed payment and manages the entire `Booking` record.
- **Cancellation and Refunds:** Facilitates `CancellationRequests` and processes `Refunds` through a defined workflow.
- **Route and Schedule Management:** Stores and updates `Route` details, `Schedule` information (date, time, duration), and real-time `FlightStatus` (SCHEDULED, BOARDING, DEPARTED, etc.).

### 2. Payment and Transaction Processing
- **Multiple Payment Methods:** Supports various options including `CreditCard`, `DebitCArd`, `Ewallet` (e.g., GCash), and `BankTransfer`.
- **Secure Transactions:** Manages `Transaction` records with unique IDs, timestamps, and status.
- **Financial Documentation:** Automatically generates `Invoices` and uses a `TaxCalculator` for accurate billing.
- **Discount Management:** Applies promo codes and loyalty benefits via the `DiscountManager`.

### 3. Check-in and Boarding Processes
- **Flexible Check-in:** Offers both physical `CheckInCounter` processing and `OnlineCheckIn` with digital seat selection.
- **Boarding Pass Issuance:** Generates the `BoardingPass` after successful `CheckIn`.
- **Security and Control:** Integration with `SecurityScreening` and `PassportControl` for verifying passenger identity and luggage.
- **Baggage Handling:** Manages `Baggage` identification using `BaggageTags` and tracks luggage location via `BaggageTracking`.

### 4. Flight Operations and Aircraft Management
- **Flight Control Coordination:** Real-time management and communication with `AirTrafficControl` regarding `Runway` and takeoff/landing procedures.
- **In-Flight Monitoring:** Uses the `FlightTracker` to monitor real-time location and status, along with `FuelMonitor` and `NavigationSystem` tracking.
- **Aircraft Status and Maintenance:** Stores `Aircraft` details, `Engine` specifications, and comprehensive `MaintenanceRecords` in the `Hangar`.
- **Safety and Emergency Systems:** Features an integrated `EmergencySystem` and uses `Weather` data for pre-flight planning.

### 5. Post-Flight and Customer Services
- **Luggage Retrieval:** Directs passengers to the correct `BaggageClaim` area.
- **Passenger Feedback:** Collects `Feedback` and formal `Survey` data to measure satisfaction.
- **Customer Support:** Offers a dedicated `CustomerService` channel for complaints and assistance, as well as `LostAndFound` management.
- **Loyalty Programs:** Manages the `LoyaltyProgram`, tracks points, and handles `Reward` redemption.

---

## System Classes and Structure
---
This section outlines the primary classes and their roles within the SkyLink system, grouped by domain.

### People
- Person - Base class for all individuals
- Passenger - Can book flights, make payments, check in
- Staff - Base class for employees at airport or airline
- Pilot - Flies the aircraft
- CoPilot - Assists the pilot during flight
- CabinCrew - Attends to passengers onboard
- GroundCrew - Manages boarding, baggage, maintenance
- SecurityOfficier - Handles security checks
- AirTrafficController - Manages flight landing/takeoff
- CheckInAgent - Processes passenger check-ins
- SystemAdmin - Managers users, flights, and database

### Airport Structure
- Airport - Represents one airport: has terminals, runways, and gates
- Terminal - Sub-division inside airport: manages gates and facilities
- Gate - Specific gate where passengers board aircraft
- Runway - Used for aircraft takeoff and landing
- Hangar - Stores aircraft for maintenance
- ParkingBay - Temporary aircraft parking area
- BaggageClaim - Area where luggage is retrieved
- SecurityCheck - Manages screening and verification
- CustomsOffice - Processes international passengers
- Lounge - Passenger waiting area

### Aircraft Management
- Aircraft - Represents a plane; contains model, capacity, and status
- Seat - Represent a seat (economy/business/first)
- Engine - Represents plane’s engine details
- FuelSystem - Tracks fuel before takeoff
- NavigationSystem - Handles route tracking
- MaintenanceRecord - Stores inspection logs
- FlightDeck - Cockpit details and crew area
- CargoHold - Stores baggage and cargo

### Booking & Flight
- Flight - Core class; has flight number, origin, destination, schedule
- Route - Contains origin airport, destination airport, and distance
- Schedule - Date, time, duration, status
- FlightStatus - Enum: SCHEDULE, BOARDING, DEPARTED, DELAYED, ARRIVED, CANCELLED
- Booking - Handles reservation date (passenger, flight, seat)
- Ticket - Generated after payment is confirmed
- BoardingPass - Issued after check-in
- CheckIn - Links passenger to flight and seat before boarding
- ReservationSystem - Central controller for bookings
- CancellationRequest - Handles cancellation and refunds
- Refund - Processes refund transactions

### Payment System
- Payment - Base payment process
- Transaction - Hold reference ID, timestamp, amount, status
- PaymentMethod - Abstract class (CreditCard, DebitCArd, GCash,Paypal)
- CreditCard - Payment via card
- DebitCard - Payment via debit account
- Ewallet - E.g., Gcash/PayMaya
- BankTransfer - Direct bank transaction
- Invoice - Generates billing statement
- TaxCalculator - Computes fees and taxes
- DiscountManager - Handles promo codes and discounts

### Check-in & Boarding
- CheckInCounter - Physical counter for check-in
- OnlineCheckIn - Handles online seat selection
- Boardinggate - Where passengers scan boarding pass
- SecurityScreening - Body/bagggage scanning
- PassportControl - For international flights
- Baggage - Represents passenger’s luggage
- BaggageTag - Printed tag linking bag to passenger
- BaggageTracking - Monitors luggage location

### Flight Operations
- Weather - Provides flight route weather conditions
- AirTrafficControl - Coordinates flight routes
- FlightTracker - Tracks flight status in real time
- NavigationRoute - Holds coordinates and waypoints
- FuelMonitor - Monitors consumption mid-flight
- EmergencySystem - Handles onboard emergencies

### Post-Flight Services
- BaggageClaim - Handles luggage pickup
- LostAndFound - For misplaced items
- CustomerService - Handles complaints and assistance
- Feedback - Stores passenger reviews
- Survey - Collect satisfaction rating
- LoyaltyProgram - Tracks frequent flyer points
- Reward - Represents redeemable items
