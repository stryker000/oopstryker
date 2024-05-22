//package ppss;
//2.4
import java.util.Scanner;

class CounterThread extends Thread {
    private int start;
    private int end;
    private static int totalCount = 0;
    private static final Object lock = new Object();

    public CounterThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Counting numbers from " + start + " to " + end + "...");
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
        }
        synchronized (lock) {
            totalCount += count;
        }
    }

    public static int getTotalCount() {
        return totalCount;
    }
}

public class MultithreadingCounter24{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Total count of numbers: ");
        int totalCount = scanner.nextInt();
        System.out.print("Number of threads: ");
        int numberOfThreads = scanner.nextInt();

        CounterThread[] threads = new CounterThread[numberOfThreads];
        int range = totalCount / numberOfThreads;
        int start = 1;

        System.out.println("\nStarting concurrent counting task...");

        for (int i = 0; i < numberOfThreads; i++) {
            int end = start + range - 1;
            if (i == numberOfThreads - 1) {
                end = totalCount;
            }
            threads[i] = new CounterThread(start, end);
            threads[i].setName("Thread " + (i + 1));
            threads[i].start();
            start = end + 1;
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nAll threads have completed execution.");
        System.out.println("\nFinal Result: Total count of numbers: " + CounterThread.getTotalCount());
    }
}
