package HW2_Partition_List_86;

public class Solution {
    public ListNode partition(ListNode head, int x){
        // Base case
        if(head == null || head.next == null)
            return head;

        // define pointers
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        ListNode low = d1;
        ListNode hight = d2;

        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                low.next = cur;
                low = cur;
            }
            else{
                hight.next = cur;
                hight = cur;
            }
            cur = cur.next;
        }
        // merge two pointer
        low.next = d2.next;
        hight.next = null;

        // return the head node
        return d1.next;
    }
}

/*
* d1 -> 1 -> 2 -> 2 -> null
* d2 -> 4 -> 3 -> 5 -> null
 */
