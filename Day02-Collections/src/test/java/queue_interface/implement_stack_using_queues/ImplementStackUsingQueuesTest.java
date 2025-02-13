package queue_interface.implement_stack_using_queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueuesTest {

    @Test
    void testStackOperations() {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        // Initially, stack should be empty
        assertTrue(stack.isEmpty(), "Stack should be empty initially.");

        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Check top element
        assertEquals(3, stack.top(), "Top element should be 3.");

        // Pop elements and check order
        assertEquals(3, stack.pop(), "Popped element should be 3.");
        assertEquals(2, stack.pop(), "Popped element should be 2.");

        // Stack should not be empty yet
        assertFalse(stack.isEmpty(), "Stack should not be empty after popping two elements.");

        // Last element
        assertEquals(1, stack.pop(), "Popped element should be 1.");

        // Stack should be empty now
        assertTrue(stack.isEmpty(), "Stack should be empty after all elements are popped.");
    }
}
