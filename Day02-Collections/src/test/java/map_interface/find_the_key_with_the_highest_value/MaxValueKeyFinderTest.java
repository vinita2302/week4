package map_interface.find_the_key_with_the_highest_value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxValueKeyFinderTest {
    @Test
    public void maxValueKeyFinderTesting(){
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String result = MaxValueKeyFinder.findMaxKey(inputMap);

        String ch="B";

        Assertions.assertEquals(ch,result);
    }
}
