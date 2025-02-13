package set_interface.symmetric_difference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SysmmetricDifferenceTest {
    @Test
    public void  SysmmetricDifferenceTesting(){
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> result = SysmmetricDifference.symmetricDifference(set1, set2);
        //Expected result
        Set<Integer> symmertricResult=new HashSet<>(Set.of(1,2,4,5));
 //Check the result is equal to the expected result
        Assertions.assertEquals(symmertricResult,result);
    }
}
