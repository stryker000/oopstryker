package ppss;


import java.util.ArrayList;
import java.util.List;

// Define the Flight class with attributes flightNumber, departure, arrival, availableSeats
class Flight {
    private String flightNumber;
    private String departure;
    private String arrival;
    private int availableSeats;

    // Constructor to initialize Flight attributes
    public Flight(String flightNumber, String departure, String arrival, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.availableSeats = availableSeats;
    }

    // Getters for Flight attributes
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to book a seat on the flight
    public void bookSeat() throws SeatUnavailableException {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            throw new SeatUnavailableException("No seats available for flight " + flightNumber);
        }
    }

    // Method to cancel a seat booking on the flight
    public void cancelSeat() {
        availableSeats++;
    }

    // Method to display flight details
    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + departure + " to " + arrival + " with " + availableSeats + " seats available";
    }
}

// Define a custom exception for seat unavailability
class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String message) {
        super(message);
    }
}

// Define a custom exception for invalid date
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// Define the FlightReservationSystem class to manage flight bookings
class FlightReservationSystem {
    private List<Flight> flights;

    // Constructor to initialize the system with an empty list of flights
    public FlightReservationSystem() {
        this.flights = new ArrayList<>();
    }

    // Method to add a flight to the system
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Method to search for flights by departure and arrival
    public List<Flight> searchFlights(String departure, String arrival) {
        List<Flight> foundFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equalsIgnoreCase(departure) && flight.getArrival().equalsIgnoreCase(arrival)) {
                foundFlights.add(flight);
            }
        }
        return foundFlights;
    }

    // Method to book a flight by flight number
    public void bookFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                try {
                    flight.bookSeat();
                    System.out.println("Booking confirmed for flight " + flightNumber);
                } catch (SeatUnavailableException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred during booking confirmation.");
                }
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }

    // Method to cancel a flight booking by flight number
    public void cancelBooking(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                flight.cancelSeat();
                System.out.println("Booking cancelled for flight " + flightNumber);
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }
}

// Main class to demonstrate the flight reservation system
public class FlightReserevationDemo47 {
    public static void main(String[] args) {
        // Create an instance of FlightReservationSystem
        FlightReservationSystem system = new FlightReservationSystem();

        // Add flights to the system
        system.addFlight(new Flight("FL123", "New York", "London", 10));
        system.addFlight(new Flight("FL456", "Paris", "Tokyo", 5));
        system.addFlight(new Flight("FL789", "Sydney", "New York", 2));

        // Search for flights
        List<Flight> flights = system.searchFlights("New York", "London");
        System.out.println("Flights from New York to London:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }

        // Book a flight
        system.bookFlight("FL123");

        // Attempt to book a flight with no available seats
        system.bookFlight("FL789");
        system.bookFlight("FL789");
        system.bookFlight("FL789");  // This should trigger the SeatUnavailableException

        // Cancel a booking
        system.cancelBooking("FL123");

        // Try to cancel a booking for a non-existent flight
        system.cancelBooking("FL999");  // This should print "Flight FL999 not found."
    }
}
