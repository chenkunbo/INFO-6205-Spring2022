package HW06_Linked_List_Random_Node_382;

public class Solution {

    ListNode head = null;

    // Note that the head is guaranteed to be not null, so it contains at least one node.

    public Solution(ListNode head){
        this.head = head;
    }

    // return a random node's value
    public int getRandom(){
        ListNode curr = head;
        int i = 1;
        int res = 0;
        while(curr != null){
            if(Math.random() < 1.0 / i){
                // take this value
                res = curr.val;
            }
            i ++;
            curr = curr.next;
        }
        return res;
    }
}
