package HW8_Split_Linked_List_in_Parts_725;

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        int n = 0;
        while(head != null){
            head = head.next;
            n ++;
        }
        int len = n / k;
        int nod = n % k;
        ListNode[] ans = new ListNode[k];
        ListNode pre = dummy;
        head = dummy.next;
        int i = 0;
        while(i < k){
            ans[i] = head;
            for(int j = 0; j < len; j++){
                pre = head;
                head = head.next;
            }
            if(i < nod){
                pre = head;
                head = head.next;
            }
            pre.next = null;
            i++;
        }
        return ans;
    }
}



