class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

class TemperatureConverter {
    public static final double MIN_CELSIUS = -273.15;
    public static final double MAX_CELSIUS = 1000.0;

    public static double celsiusToFahrenheit(double celsius) throws InvalidTemperatureException {
        if (celsius < MIN_CELSIUS || celsius > MAX_CELSIUS) {
            throw new InvalidTemperatureException("Temperature should be within the range of -273.15°C to 1000°C");
        }
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) throws InvalidTemperatureException {
        if (fahrenheit < (-459.67) || fahrenheit > 1832.0) { // Fahrenheit range corresponding to Celsius range
            throw new InvalidTemperatureException("Temperature should be within the range of -459.67°F to 1832°F");
        }
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class ps4 {
    public static void main(String[] args) {
        try {
            double celsius = 25;
            double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
            System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");

            double fahrenheitValue = 77.0;
            double celsiusValue = TemperatureConverter.fahrenheitToCelsius(fahrenheitValue);
            System.out.println(fahrenheitValue + "°F is equal to " + celsiusValue + "°C");


        } catch (InvalidTemperatureException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
