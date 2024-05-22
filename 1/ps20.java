import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// BankAccount Interface
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankAccount toAccount, double amount);
    double getBalance();
    List<String> getTransactions();
}

// SavingsAccount Class
class SavingsAccount implements BankAccount {
    private double balance;
    private List<String> transactions;

    public SavingsAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
        } else {
            transactions.add("Failed withdrawal attempt: " + amount);
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add("Transferred: " + amount + " to " + toAccount.getClass().getSimpleName());
        } else {
            transactions.add("Failed transfer attempt: " + amount + " to " + toAccount.getClass().getSimpleName());
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                '}';
    }
}

// CheckingAccount Class
class CheckingAccount implements BankAccount {
    private double balance;
    private List<String> transactions;

    public CheckingAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
        } else {
            transactions.add("Failed withdrawal attempt: " + amount);
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add("Transferred: " + amount + " to " + toAccount.getClass().getSimpleName());
        } else {
            transactions.add("Failed transfer attempt: " + amount + " to " + toAccount.getClass().getSimpleName());
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + balance +
                '}';
    }
}

// BankingSystemManager Class
public class ps20 {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: transfer(); break;
                case 5: viewTransactions(); break;
                case 6: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Banking System Menu ---");
        System.out.println("1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View transactions");
        System.out.println("6. Exit");
    }

    private static void createAccount() {
        System.out.print("Enter account type (1 for Savings, 2 for Checking): ");
        int accountType = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();

        BankAccount account;
        if (accountType == 1) {
            account = new SavingsAccount();
        } else {
            account = new CheckingAccount();
        }
        accounts.put(accountId, account);
        System.out.println("Account created with ID: " + accountId);
    }

    private static void deposit() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.deposit(amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transfer() {
        System.out.print("Enter source account ID: ");
        String sourceAccountId = scanner.nextLine();
        BankAccount sourceAccount = accounts.get(sourceAccountId);
        if (sourceAccount != null) {
            System.out.print("Enter destination account ID: ");
            String destinationAccountId = scanner.nextLine();
            BankAccount destinationAccount = accounts.get(destinationAccountId);
            if (destinationAccount != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = Double.parseDouble(scanner.nextLine());
                sourceAccount.transfer(destinationAccount, amount);
            } else {
                System.out.println("Destination account not found.");
            }
        } else {
            System.out.println("Source account not found.");
        }
    }

    private static void viewTransactions() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            System.out.println("Transactions for account ID " + accountId + ":");
            for (String transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}

