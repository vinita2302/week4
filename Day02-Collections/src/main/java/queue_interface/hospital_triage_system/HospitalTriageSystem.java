package queue_interface.hospital_triage_system;

import java.util.*;


public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Define a priority queue with a custom comparator (higher severity first)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        // Add patients to the queue
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        // Process patients based on priority
        System.out.println("Order of Treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
