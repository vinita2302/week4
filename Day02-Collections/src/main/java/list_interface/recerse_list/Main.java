package list_interface.recerse_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(" ArrayList: "+list);
        ReverseArrayList.reverseArrayList(list);
        System.out.println("Reverse The ArrayList: "+list);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(" LinkedList: "+list1);
        ReverseLinkedList.reverseLinkedList(list1);
        System.out.println("Reverse The LinkedList: "+list1);

    }
}
