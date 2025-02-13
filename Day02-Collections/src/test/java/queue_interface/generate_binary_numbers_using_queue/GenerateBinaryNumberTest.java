package queue_interface.generate_binary_numbers_using_queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GenerateBinaryNumberTest {

    @Test
    void testGenerateBinaryNumbers() {
        int N = 5;
        List<String> expectedOutput = List.of("1", "10", "11", "100", "101");

        List<String> actualOutput = GenerateBinaryNumber.generateBinaryNumbers(N);

        assertEquals(expectedOutput, actualOutput, "Generated binary numbers should match expected values.");
    }
}
