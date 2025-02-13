package set_interface.convert_a_set_to_a_sorted_list;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
public class ConversionOfSetToListTest {
    @Test
        public  void ConversionOfSetToListTesting() {
            Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

            List<Integer> sortedList = ConversionOfSetToList.convertToSortedList(set);

            //Expected Result
           List<Integer> resultSet1 = new ArrayList<>(Arrays.asList(1,3,5,9));

            Assertions.assertEquals(sortedList,resultSet1);
        }
    }

