package map_interface.word_frequency_counter;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> wordFrequencyCounter(String fileName) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z ]", " ");

                // Split the line into words
                String[] words = line.split("\\s+");

                // Count words
                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty words
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String fileName = "input.txt"; // Change this to your file path
        Map<String, Integer> wordCount = wordFrequencyCounter(fileName);

        // Print word frequencies
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}