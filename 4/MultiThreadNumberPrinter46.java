package ppss;

class NumberPrinter {
    private int currentNumber = 1; // Starting number

    // Method to print numbers, synchronized to ensure order
    public synchronized void printNumbers(int threadId, int start, int end) {
        for (int i = start; i <= end; i++) {
            // Wait until it's the current thread's turn to print
            while (currentNumber != i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread " + threadId + " prints: " + i);
            currentNumber++;
            notifyAll(); // Notify all waiting threads
        }
    }
}

class NumberPrintingThread extends Thread {
    private NumberPrinter numberPrinter;
    private int threadId;
    private int start;
    private int end;

    // Constructor to initialize thread details
    public NumberPrintingThread(NumberPrinter numberPrinter, int threadId, int start, int end) {
        this.numberPrinter = numberPrinter;
        this.threadId = threadId;
        this.start = start;
        this.end = end;
    }

    // Override the run method to execute printing
    @Override
    public void run() {
        numberPrinter.printNumbers(threadId, start, end);
    }
}

public class MultiThreadNumberPrinter46 {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        // Create threads, each responsible for a subset of numbers
        NumberPrintingThread thread1 = new NumberPrintingThread(numberPrinter, 1, 1, 3);
        NumberPrintingThread thread2 = new NumberPrintingThread(numberPrinter, 2, 4, 7);
        NumberPrintingThread thread3 = new NumberPrintingThread(numberPrinter, 3, 8, 10);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
