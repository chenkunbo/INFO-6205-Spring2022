package HW4_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_2058;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head){

        int min_distance = Integer.MAX_VALUE;
        int first_ma_index = -1;
        int prev_ma_index = -1;
        int index = 1;
        ListNode prev = head;  // index 0
        ListNode curr = head.next;  // index 1

        while(curr.next != null){
            // check for local maxima or local minima
            if(curr.val > prev.val && curr.val > curr.next.val || curr.val < prev.val && curr.val < curr.next.val){

                if(first_ma_index == -1){  // only assign once
                    first_ma_index = index;
                }
                if(prev_ma_index != -1){
                    min_distance = Math.min(min_distance, index - prev_ma_index);
                }

                prev_ma_index = index;
                System.out.println("prev_ma_index: " + prev_ma_index);
            }

            prev = curr;
            curr = curr.next;
            ++index;
        }
        if(min_distance == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        return new int[]{min_distance, prev_ma_index - first_ma_index};
    }

}
