package map_interface.merge_two_maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class MergeMapsTest {
    @Test
    public void mergeMapsTesting(){
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedMap = MergeMaps.mergeTwoMaps(map1, map2);

        Map<String, Integer> expectedMergedMap = new HashMap<>(Map.of("A", 1, "B", 5,"C",4));

        Assertions.assertEquals(expectedMergedMap,mergedMap);



    }
}
