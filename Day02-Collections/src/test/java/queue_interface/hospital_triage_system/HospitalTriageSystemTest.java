package queue_interface.hospital_triage_system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class HospitalTriageSystemTest {

    @Test
    void testTriageOrder() {
        // Create priority queue with severity-based sorting
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Add patients
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        // Expected treatment order (highest severity first)
        List<String> expectedOrder = List.of("Alice", "John", "Bob");
        List<String> actualOrder = new ArrayList<>();

        // Process patients
        while (!triageQueue.isEmpty()) {
            actualOrder.add(triageQueue.poll().name);
        }

        assertEquals(expectedOrder, actualOrder, "Patients should be treated in order of severity.");
    }
}

