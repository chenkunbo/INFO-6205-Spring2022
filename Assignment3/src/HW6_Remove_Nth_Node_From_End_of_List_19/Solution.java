package HW6_Remove_Nth_Node_From_End_of_List_19;

public class Solution {
    public ListNode removeNthfromEnd(ListNode head, int n){
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;

        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for(int i = 1; i <= n + 1; i ++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy_head.next;
    }

}
