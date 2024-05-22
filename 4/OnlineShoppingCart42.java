package ppss;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface defining methods for purchasable items
interface Purchasable {
    void addItem(String itemName, double price);
    void removeItem(String itemName);
    double calculateTotalPrice();
}

// Class representing an Electronics item
class Electronics implements Purchasable {
    private List<Item> items = new ArrayList<>();

    @Override
    public void addItem(String itemName, double price) {
        items.add(new Item(itemName, price));
    }

    @Override
    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    @Override
    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}

// Class representing a Clothing item
class Clothing implements Purchasable {
    private List<Item> items = new ArrayList<>();

    @Override
    public void addItem(String itemName, double price) {
        items.add(new Item(itemName, price));
    }

    @Override
    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    @Override
    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}

// Class representing a Book item
class Books implements Purchasable {
    private List<Item> items = new ArrayList<>();

    @Override
    public void addItem(String itemName, double price) {
        items.add(new Item(itemName, price));
    }

    @Override
    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    @Override
    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}

// Class representing a generic Item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Class to manage the shopping cart
class ShoppingCartManager {
    private Electronics electronics = new Electronics();
    private Clothing clothing = new Clothing();
    private Books books = new Books();

    public void addItemToCart(String category, String itemName, double price) {
        switch (category.toLowerCase()) {
            case "electronics":
                electronics.addItem(itemName, price);
                break;
            case "clothing":
                clothing.addItem(itemName, price);
                break;
            case "books":
                books.addItem(itemName, price);
                break;
            default:
                System.out.println("Invalid category.");
        }
    }

    public void removeItemFromCart(String category, String itemName) {
        switch (category.toLowerCase()) {
            case "electronics":
                electronics.removeItem(itemName);
                break;
            case "clothing":
                clothing.removeItem(itemName);
                break;
            case "books":
                books.removeItem(itemName);
                break;
            default:
                System.out.println("Invalid category.");
        }
    }

    public void calculateTotalPrice() {
        double total = electronics.calculateTotalPrice() + clothing.calculateTotalPrice() + books.calculateTotalPrice();
        System.out.println("Total Price: $" + total);
    }

    public void displayCart() {
        System.out.println("Cart contents:");
        System.out.println("Electronics: " + electronics.calculateTotalPrice());
        System.out.println("Clothing: " + clothing.calculateTotalPrice());
        System.out.println("Books: " + books.calculateTotalPrice());
    }

    public void purchase() {
        System.out.println("Purchasing items...");
        calculateTotalPrice();
        System.out.println("Purchase successful!");
    }
}

// Main class to interact with the user
public class OnlineShoppingCart42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCartManager cartManager = new ShoppingCartManager();
        
        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Cart");
            System.out.println("4. Purchase");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category (Electronics/Clothing/Books): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    cartManager.addItemToCart(category, itemName, price);
                    break;
                case 2:
                    System.out.print("Enter category (Electronics/Clothing/Books): ");
                    category = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    itemName = scanner.nextLine();
                    cartManager.removeItemFromCart(category, itemName);
                    break;
                case 3:
                    cartManager.displayCart();
                    break;
                case 4:
                    cartManager.purchase();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
