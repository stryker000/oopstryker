package ppss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transferFunds(BankingAccount toAccount, double amount);
    double getBalance();
    void addTransaction(String transaction);
    void printTransactions();
}

class SavingsAccount implements BankingAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactions;

    public SavingsAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Initial deposit: $" + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void transferFunds(BankingAccount toAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            toAccount.deposit(amount);
            addTransaction("Transfer to Account " + ((SavingsAccount) toAccount).accountNumber + ": $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public void printTransactions() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}

class CheckingAccount implements BankingAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactions;

    public CheckingAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Initial deposit: $" + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void transferFunds(BankingAccount toAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            toAccount.deposit(amount);
            addTransaction("Transfer to Account " + ((CheckingAccount) toAccount).accountNumber + ": $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public void printTransactions() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}

public class MainApplication22 {
    private static Map<String, BankingAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    viewTransactions();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account type (Savings/Checking): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists.");
            return;
        }

        BankingAccount account;
        if (accountType.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accountNumber, initialDeposit);
        } else if (accountType.equalsIgnoreCase("Checking")) {
            account = new CheckingAccount(accountNumber, initialDeposit);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BankingAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BankingAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.withdraw(amount);
        System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
    }

    private static void transferFunds() {
        System.out.print("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        System.out.print("Enter recipient's account number: ");
        String toAccountNumber = scanner.nextLine();
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BankingAccount fromAccount = accounts.get(fromAccountNumber);
        BankingAccount toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        fromAccount.transferFunds(toAccount, amount);
        System.out.println("Transfer successful.");
    }

    private static void viewTransactions() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankingAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.printTransactions();
    }
}
