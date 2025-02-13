package set_interface.union_and_intersection_of_two_sets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersectionTest {
    @Test
    public void unionIntersectionTesting(){
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> unionSet = UnionIntersection.union(set1, set2);
        Set<Integer> intersectionSet = UnionIntersection.intersection(set1, set2);

        //Expexted output
        Set<Integer> resultUnion=new HashSet<>(Set.of(1,2,3,4,5));
        Set<Integer> resultIntersection=new HashSet<>(Set.of(3));

        Assertions.assertEquals(unionSet,resultUnion);
        Assertions.assertEquals(resultIntersection,intersectionSet);

    }
}
