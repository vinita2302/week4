package queue_interface.reverse_queue;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseQueueTest {

    @Test
    void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Expected reversed queue: [30, 20, 10]
        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.offer(30);
        expectedQueue.offer(20);
        expectedQueue.offer(10);

        ReverseQueue.reverseQueue(queue);

        assertEquals(expectedQueue, queue, "Queue should be reversed correctly.");
    }
}
