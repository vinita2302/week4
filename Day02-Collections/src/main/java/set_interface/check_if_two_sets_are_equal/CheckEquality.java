package set_interface.check_if_two_sets_are_equal;

import java.util.HashSet;
import java.util.Set;

public class CheckEquality{
    public static <T> boolean equal(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

boolean areequal=equal(set1,set2);

        System.out.println("Are the sets equal? "+ " "+areequal);
    }
}

