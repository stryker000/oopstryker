import java.util.Scanner;

public class ps16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TablePrinter tablePrinter = new TablePrinter();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create 5 threads");
            System.out.println("2. Synchronized methods to print tables");
            System.out.println("3. Demonstrate daemon thread");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createThreads();
                    break;
                case 2:
                    demonstrateSynchronizedMethods(tablePrinter);
                    break;
                case 3:
                    demonstrateDaemonThread();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // a. Create 5 threads
    private static void createThreads() {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new MyRunnable(), "Thread-" + i);
            thread.start();
        }
    }

    // b. Two Synchronized methods to print tables
    private static void demonstrateSynchronizedMethods(TablePrinter tablePrinter) {
        Thread thread1 = new Thread(() -> tablePrinter.printTableOf2(), "Table-2-Thread");
        Thread thread2 = new Thread(() -> tablePrinter.printTableOf5(), "Table-5-Thread");

        thread1.start();
        thread2.start();
    }

    // c. Demonstration for daemon thread
    private static void demonstrateDaemonThread() {
        Thread daemonThread = new Thread(new MyDaemonRunnable(), "Daemon-Thread");
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main thread sleeping for 2 seconds...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread exiting...");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}

class TablePrinter {
    public synchronized void printTableOf2() {
        System.out.println("Printing 2's table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 x " + i + " = " + (2 * i));
            try {
                Thread.sleep(500); // Adding delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printTableOf5() {
        System.out.println("Printing 5's table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(500); // Adding delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDaemonRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running as a daemon thread.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
