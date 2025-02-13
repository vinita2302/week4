package list_interface.remove_duplicates_while_preserving_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RemoveDuplicates {

        public static List<Integer> remove(List<Integer> list) {
            List<Integer> list1 = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                if (!list1.contains(list.get(i))) {
                    list1.add(list.get(i));
                }
            }

            return list1;
        }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(3,1,2,2,3,4));
        List<Integer> list2=remove(list);
        System.out.println(list2);
    }
}
