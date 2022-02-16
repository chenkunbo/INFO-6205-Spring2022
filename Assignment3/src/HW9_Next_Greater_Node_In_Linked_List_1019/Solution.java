package HW9_Next_Greater_Node_In_Linked_List_1019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head){
        List<Integer> lst = new ArrayList<>();
        while(head != null){
            lst.add(head.val);
            head = head.next;
        }
        int[] output = new int[lst.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < lst.size(); i ++){
            while(!stack.isEmpty() && lst.get(stack.peek()) < lst.get(i)){
                output[stack.pop()] = lst.get(i);

            }
            stack.add(i);
        }
        return output;
    }

}
