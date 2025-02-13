package map_interface.invert_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class InvertMapTest {
    @Test
    public void invertMapTesting(){

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(1, Arrays.asList("A", "C"));
        expectedMap.put(2, Collections.singletonList("B"));

        Map<Integer, List<String>> invertedMap = InvertMap.invertMap(inputMap);

        Assertions.assertEquals(expectedMap.size(), invertedMap.size(), "Inverted map should have correct size");
        Assertions.assertTrue(invertedMap.containsKey(1), "Inverted map should contain key 1");
        Assertions.assertTrue(invertedMap.containsKey(2), "Inverted map should contain key 2");
        Assertions.assertTrue(invertedMap.get(1).containsAll(Arrays.asList("A", "C")), "Values for key 1 should be A and C");
        Assertions.assertTrue(invertedMap.get(2).contains("B"), "Values for key 2 should be B");
    }
}
