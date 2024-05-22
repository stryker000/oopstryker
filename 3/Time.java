package ppss;
/*3.1
 * Create a class called Time, which has three private instance variables – 
 * hour, min and sec. It contains a method called add( ) which takes one Time object 
 * as parameter and prints the added value of the calling Time object and passes the Time object. 
 * In the main method, declare two Time objects and assign values using the constructor and call 
 * the add() method
 */
class Time {
    private int hour;
    private int min;
    private int sec;

    // Constructor to initialize the time
    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    // Method to add another Time object to this Time object
    public void add(Time other) {
        int totalSeconds = this.toSeconds() + other.toSeconds();
        Time result = Time.fromSeconds(totalSeconds);
        System.out.println("Added Time: " + result);
    }

    // Convert Time object to total seconds
    private int toSeconds() {
        return hour * 3600 + min * 60 + sec;
    }

    // Create a Time object from total seconds
    private static Time fromSeconds(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        return new Time(hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    public static void main(String[] args) {
        // Create two Time objects
        Time time1 = new Time(2, 45, 50);
        Time time2 = new Time(1, 20, 30);

        // Print the initial times
        System.out.println("Time 1: " + time1);
        System.out.println("Time 2: " + time2);

        // Add the two times
        time1.add(time2);
    }
}
