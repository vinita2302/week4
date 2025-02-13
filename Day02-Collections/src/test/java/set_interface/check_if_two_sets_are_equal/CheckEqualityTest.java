package set_interface.check_if_two_sets_are_equal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CheckEqualityTest {
    @Test
    public void checkTesting(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        boolean areequal=CheckEquality.equal(set1,set2);

        boolean result=true;

        Assertions.assertEquals(result,areequal);

    }
}
