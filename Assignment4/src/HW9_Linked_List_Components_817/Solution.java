package HW9_Linked_List_Components_817;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numComponents(ListNode head, int[] nums){
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
            hashSet.add(nums[i]);
        }

        ListNode parent = null;
        ListNode current = head;
        int numOfComponents = 0;
        while(current != null){
            if(parent == null){
                if(hashSet.contains(current.val)){
                    numOfComponents ++;
                }
            }else{
                if(!hashSet.contains(parent.val) && hashSet.contains(current.val)){
                    numOfComponents ++;
                }
            }

            parent = current;
            current = current.next;
        }

        return numOfComponents;
    }
}



