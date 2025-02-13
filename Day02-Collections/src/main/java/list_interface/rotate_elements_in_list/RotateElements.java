package list_interface.rotate_elements_in_list;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class RotateElements {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int n = list.size();
        positions = positions % n;

        List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, n));
        rotatedList.addAll(list.subList(0, positions));

        return rotatedList;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println(rotatedList);
    }
}

