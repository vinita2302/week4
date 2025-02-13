package list_interface.find_frequency_of_element;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FrequencyOfElementTest {
    @Test
    public  void testing(){
     List<String> list1=new LinkedList<>();
        list1.add("apple");
        list1.add("banana");
        list1.add("apple");
        list1.add("orange");

HashMap<String,Integer> mp=new HashMap<>();
        HashMap<String,Integer> mp1=new HashMap<>();
        mp1.put("apple",2);
        mp1.put("orange",1);
        mp1.put("banana",1);

        HashMap<String,Integer> mp3=new HashMap<>();
        HashMap<String,Integer> mp2=new HashMap<>();
        mp1.put("apple",2);
        mp1.put("orange",1);
        mp1.put("banana",1);

        FrequencyOfElement.frequency(list1,mp);
        Assertions.assertEquals(mp1,mp,"Test Case Pass");
        Assertions.assertEquals(mp2,mp3,"Test Case Fail");
    }
}
