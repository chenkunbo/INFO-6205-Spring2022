package Reorder_List_143;

public class Solution {
    // 143. Reorder List
    // first define for singly-linked list
    public void reorderList(ListNode head){
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode last = head.next;
        ListNode secondLast = head;

        while(last.next != null){
            last = last.next;
            secondLast = secondLast.next;
        }

        ListNode temp = head.next;
        head.next = last;
        last.next = temp;
        secondLast.next = null;

        reorderList(temp);
    }

}
