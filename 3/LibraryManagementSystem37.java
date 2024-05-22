package ppss;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book Class
class Book {
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true; // By default, a book is available when added
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // toString method
    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Available=" + (available ? "Yes" : "No") + "]";
    }
}

// Library Class
class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Check out a book
    public boolean checkOutBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    // Check in a book
    public boolean checkInBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}

// Main Class
public class LibraryManagementSystem37 {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Check in a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Displaying all books:");
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Book book = library.searchBookByTitle(title);
                    if (book != null) {
                        System.out.println("Book found: " + book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to check out: ");
                    title = scanner.nextLine();
                    if (library.checkOutBook(title)) {
                        System.out.println("Book checked out successfully.");
                    } else {
                        System.out.println("Book not available for checkout.");
                    }
                    break;
                case 5:
                    System.out.print("Enter book title to check in: ");
                    title = scanner.nextLine();
                    if (library.checkInBook(title)) {
                        System.out.println("Book checked in successfully.");
                    } else {
                        System.out.println("Book not found or already checked in.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
