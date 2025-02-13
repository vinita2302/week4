package list_interface.list_interface.remove_duplicates_while_preserving_order;

import list_interface.remove_duplicates_while_preserving_order.RemoveDuplicates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesTest {
    @Test
    public void removeTest(){
            //Input for the test
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,1,2,3,4));
        //Expected output
        List<Integer> list1= new ArrayList<>(Arrays.asList(1,2,3,4));
        // Call the remove method and get the result
        List<Integer> list2=RemoveDuplicates.remove(list);
        // Check actual output matches the expected output
        Assertions.assertEquals(list1,list2);

    }
}
