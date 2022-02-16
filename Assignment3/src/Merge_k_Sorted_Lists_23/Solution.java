package Merge_k_Sorted_Lists_23;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;

        int interval = 1;
        int len = lists.length;
        while(interval < len){
            for(int i = 0; i < len - interval; i += (interval*2)){
                merge(lists, i, i + interval);
            }
            interval*=2;

        }
        return lists[0];
    }
    public void merge(ListNode[] lists, int index1, int index2){
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        ListNode l1 = lists[index1];
        ListNode l2 = lists[index2];

        while(l1 != null || l2 != null){
            if(l1 == null){
                ptr.next = l2;
                break;
            }
            if(l2 == null){
                ptr.next = l1;
                break;
            }
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }
            else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        lists[index1] = ans.next;
    }

}
