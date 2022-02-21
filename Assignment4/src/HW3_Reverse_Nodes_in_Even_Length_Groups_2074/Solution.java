package HW3_Reverse_Nodes_in_Even_Length_Groups_2074;

public class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode lastEnd = dummy, nextStart = null;
        ListNode reverseStart = null, reverseEnd = null;
        int counter = 0;

        while (curr.next != null) {
            counter++;
            lastEnd = curr;
            reverseStart = curr.next;
            reverseEnd = curr;

            int cnt = 0;
            for (int i = 0; i < counter && curr != null; i++) {
                cnt++;
                reverseEnd = curr;
                curr = curr.next;
            }

            if (cnt % 2 == 0 && curr == null) {
                break;
            } else if (cnt % 2 == 1 && curr != null) {
                continue;
            }

            reverseEnd = curr == null ? reverseEnd : curr;
            nextStart = reverseEnd.next;
            reverseEnd.next = null;
            lastEnd.next = null;
            reverse(reverseStart, reverseEnd);

            lastEnd.next = reverseEnd;
            reverseStart.next = nextStart;
            curr = reverseStart;
        }

        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        if (start == end) {
            return;
        }

        ListNode prev = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }
}
