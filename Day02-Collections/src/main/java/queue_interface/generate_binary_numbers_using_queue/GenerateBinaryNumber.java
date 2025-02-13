package queue_interface.generate_binary_numbers_using_queue;

import java.util.*;

public class GenerateBinaryNumber {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Start with "1" in the queue
        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            result.add(binary);

            // Generate next two binary numbers
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " binary numbers: " + generateBinaryNumbers(N));
    }
}
