package HW8_Insert_into_a_Sorted_Circular_Linked_List_708;

public class Solution {
    public Node insert(Node head, int insertVal){
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        Node cur = head;
        while(cur.next != head){
            int cur_v = cur.val;
            int next_v = cur.next.val;
            if(cur_v <= insertVal && insertVal <= next_v){
                break;
            }
            else if(cur_v > next_v){
                if(cur_v >= insertVal && next_v >= insertVal){
                    break;
                }
                if(cur_v <= insertVal && next_v <= insertVal){
                    break;
                }
            }
            cur = cur.next;
        }
        Node temp = cur.next;
        cur.next = node;
        node.next = temp;
        return head;
    }

}
