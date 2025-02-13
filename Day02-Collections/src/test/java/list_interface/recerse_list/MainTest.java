package list_interface.recerse_list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MainTest {



        @Test
        public void testReverseList() {
            // Test case 1: Basic test with odd number of elements
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);
            list1.add(5);

            // Expected reversed list
            List<Integer> expected1 = new ArrayList<>();
            expected1.add(5);
            expected1.add(4);
            expected1.add(3);
            expected1.add(2);
            expected1.add(1);

            // Perform the reversal
       ReverseArrayList.reverseArrayList(list1);

            // Assert that the list is reversed
            Assertions.assertEquals(expected1, list1, "The list was not reversed correctly (odd length)");


            LinkedList<Integer> list2 = new LinkedList<>();
            list2.add(1);
            list2.add(2);
            list2.add(3);
            list2.add(4);

            // Expected reversed list
            List<Integer> expected2 = new ArrayList<>();
            expected2.add(4);
            expected2.add(3);
            expected2.add(2);
            expected2.add(1);

          ReverseLinkedList.reverseLinkedList(list2);

            Assertions.assertEquals(expected2, list2, "The list was not reversed correctly");



        }
}

