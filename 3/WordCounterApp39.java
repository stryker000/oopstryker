package ppss;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// WordCounter class definition
class WordCounter {
    // Method to count occurrences of each word in the given text
    public Map<String, Integer> countWords(String text) {
        // Create a map to store the word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // Split the text into words using spaces and punctuation as delimiters
        String[] words = text.split("\\W+");

        // Iterate through the words and update their counts in the map
        for (String word : words) {
            if (word.isEmpty()) {
                continue; // Skip empty words
            }
            word = word.toLowerCase(); // Convert word to lowercase for case-insensitive counting
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Return the map containing word counts
        return wordCounts;
    }
}

// Main class to interact with users
public class WordCounterApp39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        WordCounter wordCounter = new WordCounter(); // Create an instance of WordCounter

        // Prompt the user to enter a text
        System.out.println("Enter a text:");
        String text = scanner.nextLine(); // Read the input text from the user

        // Use the WordCounter class to count the occurrences of each word
        Map<String, Integer> wordCounts = wordCounter.countWords(text);

        // Display the results
        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); // Print each word and its count
        }
    }
}
