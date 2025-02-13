package set_interface.find_subsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static set_interface.find_subsets.Subsets.checkSubset;

public class SubsetsTest {
    @Test
    public void subsetsTesting() {
        Set<Integer> set = new HashSet<>(Set.of(2, 3));
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3, 4));

        boolean actualResult = checkSubset(set, set1);

        //Expected Result
        boolean Result = true;
        Assertions.assertEquals(Result, actualResult);
    }
}
