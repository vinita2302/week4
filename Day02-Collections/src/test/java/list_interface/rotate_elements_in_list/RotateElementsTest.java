package list_interface.rotate_elements_in_list;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElementsTest {
@Test
    public void rotateTesting(){
        List<Integer> list= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> list2=new ArrayList<>(Arrays.asList(3,4,5,1,2));
        int key =2 ;
       List<Integer> list1= RotateElements.rotateList(list,key);

        Assertions.assertEquals(list1,list2);


    }
}
