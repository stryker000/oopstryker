package ppss;

import java.util.ArrayList;
import java.util.List;

// Define the Book43 class with attributes title, author, ISBN, and availability status
class Book43 {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor to initialize Book43 attributes
    public Book43(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;  // New Book43s are available by default
    }

    // Getters and setters for Book43 attributes
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Method to display Book43 details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable;
    }
}

// Define the Library class to manage a collection of Book43s
class Library44 {
    private List<Book43> Book43s;

    // Constructor to initialize the Library with an empty list of Book43s
    public Library44() {
        this.Book43s = new ArrayList<>();
    }

    // Method to add a new Book43 to the library
    public void addBook43(Book43 Book43) {
        Book43s.add(Book43);
        System.out.println("Book43 added: " + Book43.getTitle());
    }

    // Method to borrow a Book43 by ISBN
    public void borrowBook43(String isbn) {
        for (Book43 Book43 : Book43s) {
            if (Book43.getIsbn().equals(isbn)) {
                if (Book43.isAvailable()) {
                    Book43.setAvailable(false);
                    System.out.println("Book43 borrowed: " + Book43.getTitle());
                } else {
                    System.out.println("Book43 is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book43 not found with ISBN: " + isbn);
    }

    // Method to return a Book43 by ISBN
    public void returnBook43(String isbn) {
        for (Book43 Book43 : Book43s) {
            if (Book43.getIsbn().equals(isbn)) {
                if (!Book43.isAvailable()) {
                    Book43.setAvailable(true);
                    System.out.println("Book43 returned: " + Book43.getTitle());
                } else {
                    System.out.println("Book43 was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book43 not found with ISBN: " + isbn);
    }

    // Method to search for Book43s by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book43 Book43 : Book43s) {
            if (Book43.getTitle().equalsIgnoreCase(title)) {
                System.out.println(Book43);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Book43s found with title: " + title);
        }
    }

    // Method to search for Book43s by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book43 Book43 : Book43s) {
            if (Book43.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(Book43);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Book43s found by author: " + author);
        }
    }

    // Method to display all available Book43s
    public void displayAvailableBook43s() {
        boolean found = false;
        for (Book43 Book43 : Book43s) {
            if (Book43.isAvailable()) {
                System.out.println(Book43);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Book43s available.");
        }
    }
}

// Main class to demonstrate the library management system
public class LibraryManagementSystem44 {
    public static void main(String[] args) {
        // Create an instance of Library
        Library44 library = new Library44();

        // Add new Book43s to the library
        library.addBook43(new Book43("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));
        library.addBook43(new Book43("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        library.addBook43(new Book43("1984", "George Orwell", "9780451524935"));

        // Demonstrate borrowing and returning Book43s
        library.borrowBook43("9780316769488");  // Borrow "The Catcher in the Rye"
        library.returnBook43("9780316769488");  // Return "The Catcher in the Rye"
        library.borrowBook43("9780061120084");  // Borrow "To Kill a Mockingbird"
        library.borrowBook43("9780061120084");  // Attempt to borrow again (should be unavailable)

        // Demonstrate searching for Book43s by title and author
        library.searchByTitle("1984");  // Search for Book43 by title
        library.searchByAuthor("George Orwell");  // Search for Book43s by author

        // Display all available Book43s
        library.displayAvailableBook43s();
    }
}
