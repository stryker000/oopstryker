package ppss;

import java.util.Scanner;

abstract class BankAccount2 {
    protected double balance;

    public BankAccount2(double initialBalance) {
        balance = initialBalance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount2 extends BankAccount2 {
    public SavingsAccount2(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to Savings Account. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class CheckingAccount2 extends BankAccount2 {
    public CheckingAccount2(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to Checking Account. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Checking Account. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class BankApplication35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount2 account = null;

        System.out.println("Welcome to the Bank Application");
        System.out.print("Enter account type (savings/checking): ");
        String accountType = scanner.nextLine();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();

        if (accountType.equalsIgnoreCase("savings")) {
            account = new SavingsAccount2(initialDeposit);
        } else if (accountType.equalsIgnoreCase("checking")) {
            account = new CheckingAccount2(initialDeposit);
        } else {
            System.out.println("Invalid account type.");
            System.exit(0);
        }

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
