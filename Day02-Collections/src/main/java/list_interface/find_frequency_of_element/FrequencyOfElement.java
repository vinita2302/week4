package list_interface.find_frequency_of_element;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FrequencyOfElement {
   public static void frequency(List<String> list,HashMap<String,Integer> mp){

       for(int i=0;i<list.size();i++){
           String key= list.get(i);
         if(mp.containsKey(key)){
             mp.put(key,mp.get(key)+1);
         }
         else{
             mp.put(key,1);
         }
       }
   }
    public static void main(String[] args) {
       List<String> list=new LinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        HashMap<String,Integer> mp=new HashMap<>();
        frequency(list,mp);
        System.out.println(mp);


    }
}
