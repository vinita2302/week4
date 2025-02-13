package list_interface.find_the_nth_element_from_the_end;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FindNthElementFormEnd {
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        // Edge case: if list is empty or N is invalid
        if (list == null || N <= 0) {
            throw new IllegalArgumentException("Invalid input: List cannot be null, and N must be positive.");
        }

        ListIterator<String> fast = list.listIterator();
        ListIterator<String> slow = list.listIterator();

        // Move fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size.");
            }
            fast.next();
        }

        // Move both fast and slow one step at a time
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow now points to the Nth element from the end
        return slow.next();
    }

    public static void main(String[] args) {


      LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);
        System.out.println("Nth element from the end: " + result);
    }
}


