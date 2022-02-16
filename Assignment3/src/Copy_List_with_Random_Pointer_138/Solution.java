package Copy_List_with_Random_Pointer_138;

import java.util.HashMap;

    // 138. Copy List with Random Pointer.
    // first define a Node class

public class Solution {
    public Node copyRandomList(Node head){
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
