package map_interface.word_frequency_counter;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyCounterTest {

    @Test
    void testWordFrequencyCounter() throws IOException {
        // Create a temporary file with test content
        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit(); // Ensure file is deleted after test

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Hello world! Hello everyone.");
        }

        // Call method to test
        Map<String, Integer> wordCount = WordFrequencyCounter.wordFrequencyCounter(tempFile.getAbsolutePath());

        // Expected word frequency
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("everyone", 1);

        assertEquals(expected, wordCount, "Word frequency count should match expected values.");
    }
}
