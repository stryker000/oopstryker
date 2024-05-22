package ppss;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Movie class definition
class Movie {
    // Attributes of a movie
    private String title;
    private String genre;
    private int duration;
    private double rating;

    // Constructor to initialize movie attributes
    public Movie(String title, String genre, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    // Getter and setter methods for movie attributes
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Override toString() method to provide a meaningful string representation of a movie
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                " minutes, rating=" + rating +
                '}';
    }
}

// Theater class definition
class Theater {
    // List to store movies and a map to store bookings
    private ArrayList<Movie> movies;
    private Map<Movie, Integer> bookings;

    // Constructor to initialize movies and bookings
    public Theater() {
        movies = new ArrayList<>();
        bookings = new HashMap<>();
    }

    // Method to add a movie to the theater
    public void addMovie(Movie movie) {
        movies.add(movie);
        bookings.put(movie, 0);  // Initialize with 0 bookings
    }

    // Method to display all available movies
    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    // Method to book a ticket for a specific movie
    public void bookTicket(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                int currentBookings = bookings.get(movie);
                bookings.put(movie, currentBookings + 1);
                System.out.println("Ticket booked successfully for " + movieTitle);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    // Method to display all booked tickets
    public void displayBookedTickets() {
        boolean hasBookings = false;
        for (Map.Entry<Movie, Integer> entry : bookings.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey().getTitle() + ": " + entry.getValue() + " tickets booked");
                hasBookings = true;
            }
        }
        if (!hasBookings) {
            System.out.println("No tickets booked.");
        }
    }

    // Method to cancel a booked ticket for a specific movie
    public void cancelTicket(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                int currentBookings = bookings.get(movie);
                if (currentBookings > 0) {
                    bookings.put(movie, currentBookings - 1);
                    System.out.println("Ticket cancelled successfully for " + movieTitle);
                } else {
                    System.out.println("No bookings to cancel for " + movieTitle);
                }
                return;
            }
        }
        System.out.println("Movie not found.");
    }
}

// Main class definition
public class OnlineTicketBookingSystem38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Theater theater = new Theater();

        // Adding some sample movies
        theater.addMovie(new Movie("Inception", "Sci-Fi", 148, 8.8));
        theater.addMovie(new Movie("The Godfather", "Crime", 175, 9.2));
        theater.addMovie(new Movie("Toy Story", "Animation", 81, 8.3));

        // Infinite loop to keep the program running until the user chooses to exit
        while (true) {
            System.out.println("\n=== Online Movie Ticket Booking System ===");
            System.out.println("1. Display available movies");
            System.out.println("2. Book tickets for a movie");
            System.out.println("3. View booked tickets");
            System.out.println("4. Cancel a booked ticket");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Switch case to handle user choices
            switch (choice) {
                case 1:
                    theater.displayMovies();
                    break;
                case 2:
                    System.out.print("Enter movie title to book: ");
                    String bookTitle = scanner.nextLine();
                    theater.bookTicket(bookTitle);
                    break;
                case 3:
                    theater.displayBookedTickets();
                    break;
                case 4:
                    System.out.print("Enter movie title to cancel booking: ");
                    String cancelTitle = scanner.nextLine();
                    theater.cancelTicket(cancelTitle);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
