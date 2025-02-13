package queue_interface.circular_buffer_simulation;


class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert an element into the circular buffer
    public void enqueue(int x) {
        // Move rear forward in circular manner
        rear = (rear + 1) % size;
        buffer[rear] = x;

        if (count < size) {
            count++; // Increase count if buffer is not full
        } else {
            // If full, move front forward to overwrite the oldest element
            front = (front + 1) % size;
        }
    }

    // Remove an element from the buffer
    public int dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Buffer is empty");
        }
        int removed = buffer[front];
        front = (front + 1) % size;
        count--;
        return removed;
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.display(); // Output: Buffer: 1 2 3

        buffer.enqueue(4); // Overwrites 1
        buffer.display(); // Output: Buffer: 2 3 4

        buffer.dequeue(); // Removes 2
        buffer.display(); // Output: Buffer: 3 4

        buffer.enqueue(5);
        buffer.display(); // Output: Buffer: 3 4 5
    }
}
