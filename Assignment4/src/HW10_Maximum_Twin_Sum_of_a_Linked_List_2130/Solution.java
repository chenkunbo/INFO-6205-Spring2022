package HW10_Maximum_Twin_Sum_of_a_Linked_List_2130;

public class Solution {
    public int pairSum(ListNode head){
        int n = 0;
        int j = 0;
        int result = 0;
        ListNode p = head;
        ListNode dummy = head;
        while(dummy.next != null){
            n ++; // counting the size of the Linked List
            dummy = dummy.next;
        }
        int[] arr = new int[n+1];
        while(p.next != null){
            arr[j] = p.val;
            j ++;
            p = p.next;
        }
        arr[j] = p.val;  // take the last node
        for(int i = 0; i < arr.length/2; i ++){
            int sum = arr[i] + arr[arr.length-1-i];
            result = Math.max(result, sum);
        }
        return result;
    }
}


