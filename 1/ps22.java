import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Purchasable interface
 interface Purchasable {
    void addItem(Purchasable item);
    void removeItem(Purchasable item);
    double calculateTotalPrice();
}

// Implement the Electronics class
 class Electronics implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Electronics(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public void addItem(Purchasable item) {
        if (item instanceof Electronics) {
            this.quantity += ((Electronics) item).getQuantity();
        }
    }

    @Override
    public void removeItem(Purchasable item) {
        if (item instanceof Electronics) {
            this.quantity -= ((Electronics) item).getQuantity();
            if (this.quantity < 0) this.quantity = 0;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "Electronics{" + "name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + '}';
    }
}

// Implement the Clothing class
    class Clothing implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Clothing(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public void addItem(Purchasable item) {
        if (item instanceof Clothing) {
            this.quantity += ((Clothing) item).getQuantity();
        }
    }

    @Override
    public void removeItem(Purchasable item) {
        if (item instanceof Clothing) {
            this.quantity -= ((Clothing) item).getQuantity();
            if (this.quantity < 0) this.quantity = 0;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "Clothing{" + "name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + '}';
    }
}

// Implement the Books class
    class Books implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Books(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public void addItem(Purchasable item) {
        if (item instanceof Books) {
            this.quantity += ((Books) item).getQuantity();
        }
    }

    @Override
    public void removeItem(Purchasable item) {
        if (item instanceof Books) {
            this.quantity -= ((Books) item).getQuantity();
            if (this.quantity < 0) this.quantity = 0;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "Books{" + "name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + '}';
    }
}

// Implement the ShoppingCart class
    class ShoppingCart {
    List<Purchasable> items = new ArrayList<>();

    public void addItem(Purchasable item) { items.add(item); }
    public void removeItem(Purchasable item) { items.remove(item); }
    
    public double calculateTotalPrice() {
        double total = 0;
        for (Purchasable item : items) {
            total += item.calculateTotalPrice();
        }
        return total;
    }

    public void displayCartItems() {
        for (Purchasable item : items) {
            System.out.println(item);
        }
    }

    public void checkout() {
        System.out.println("Total price: $" + calculateTotalPrice());
        items.clear();
        System.out.println("Thank you for your purchase!");
    }
}

// Implement the ShoppingCartManager class
public class ps22 {
    static Scanner scanner = new Scanner(System.in);
    static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addItemToCart(); break;
                case 2: removeItemFromCart(); break;
                case 3: cart.displayCartItems(); break;
                case 4: cart.checkout(); break;
                case 5: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Shopping Cart Menu ---");
        System.out.println("1. Add item to cart");
        System.out.println("2. Remove item from cart");
        System.out.println("3. Display cart items");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
    }

    private static void addItemToCart() {
        System.out.println("Choose item type: 1. Electronics 2. Clothing 3. Books");
        int itemType = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter item quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Purchasable item;
        if (itemType == 1) item = new Electronics(name, price, quantity);
        else if (itemType == 2) item = new Clothing(name, price, quantity);
        else item = new Books(name, price, quantity);

        cart.addItem(item);
        System.out.println("Item added to cart.");
    }

    private static void removeItemFromCart() {
        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();
        for (Purchasable item : cart.items) {
            if ((item instanceof Electronics && ((Electronics) item).getName().equalsIgnoreCase(name)) ||
                (item instanceof Clothing && ((Clothing) item).getName().equalsIgnoreCase(name)) ||
                (item instanceof Books && ((Books) item).getName().equalsIgnoreCase(name))) {
                cart.removeItem(item);
                System.out.println("Item removed from cart.");
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }
}
