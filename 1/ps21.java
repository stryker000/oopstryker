import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book Class
class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

// Library Class
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void borrowBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
            }
        }
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public void displayAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}

// LibraryManager Class
public class ps21 {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addBook(); break;
                case 2: borrowBook(); break;
                case 3: returnBook(); break;
                case 4: searchByTitle(); break;
                case 5: searchByAuthor(); break;
                case 6: displayAvailableBooks(); break;
                case 7: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add book");
        System.out.println("2. Borrow book");
        System.out.println("3. Return book");
        System.out.println("4. Search book by title");
        System.out.println("5. Search book by author");
        System.out.println("6. Display available books");
        System.out.println("7. Exit");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        
        Book book = new Book(title, author, ISBN);
        library.addBook(book);
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String ISBN = scanner.nextLine();
        library.borrowBook(ISBN);
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String ISBN = scanner.nextLine();
        library.returnBook(ISBN);
    }

    private static void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        library.searchByTitle(title);
    }

    private static void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        library.searchByAuthor(author);
    }

    private static void displayAvailableBooks() {
        library.displayAvailableBooks();
    }
}
