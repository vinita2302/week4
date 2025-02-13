package queue_interface.circular_buffer_simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    @Test
    void testCircularBufferOperations() {
        CircularBuffer buffer = new CircularBuffer(3);

        // Enqueue elements
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // Overwrite first element
        buffer.enqueue(4); // 1 should be overwritten

        // Expected state: [2, 3, 4]
        assertEquals(2, buffer.dequeue(), "First dequeued element should be 2");
        assertEquals(3, buffer.dequeue(), "Second dequeued element should be 3");
        assertEquals(4, buffer.dequeue(), "Third dequeued element should be 4");

        // Buffer should be empty now
        assertThrows(IllegalStateException.class, buffer::dequeue, "Dequeueing from an empty buffer should throw an exception");
    }
}
