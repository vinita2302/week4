package set_interface.find_subsets;


import java.util.HashSet;
import java.util.Set;

public class Subsets {
    public static boolean checkSubset(  Set<Integer> set,  Set<Integer> set1){
        boolean result=set.containsAll(set);
        return  result;
    }
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>(Set.of(2,3));
        Set<Integer> set1=new HashSet<>(Set.of(1,2,3,4));

        System.out.println("The give set is subset of another set: "+checkSubset(set,set1));

    }
}
