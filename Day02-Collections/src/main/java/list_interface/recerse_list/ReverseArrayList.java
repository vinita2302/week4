package list_interface.recerse_list;

import java.util.ArrayList;

public class ReverseArrayList {

    public static void reverseArrayList(ArrayList<Integer> st){
        int left=0;
        int right=st.size()-1;
        while(left<right){
            int temp=st.get(left);
            st.set(left,st.get(right));
            st.set(right,temp);
            left++;
            right--;
        }
    }
}
