public class SequentialNumberPrinter {
    private static final int TOTAL_NUMBERS = 10;
    private static int currentNumber = 1;
    
    public static void main(String[] args) {
        // Create a lock object for synchronization
        final Object lock = new Object();
        
        // Create threads
        Thread thread1 = new Thread(new NumberPrinter(lock, 1));
        Thread thread2 = new Thread(new NumberPrinter(lock, 2));
        Thread thread3 = new Thread(new NumberPrinter(lock, 3));

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    static class NumberPrinter implements Runnable {
        private final Object lock;
        private final int threadId;
        
        public NumberPrinter(Object lock, int threadId) {
            this.lock = lock;
            this.threadId = threadId;
        }
        
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentNumber > TOTAL_NUMBERS) {
                        break;
                    }
                    
                    if (currentNumber % 3 == threadId % 3) {
                        System.out.println("Thread " + threadId + ": " + currentNumber);
                        currentNumber++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
