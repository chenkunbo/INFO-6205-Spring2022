package HW8_Insert_into_a_Sorted_Circular_Linked_List_708;

public class Node {
    public int val;
    public Node next;

    public Node(){}

    public Node(int _val){
        val = _val;

    }

    public Node(int _val, Node _next){
        val = _val;
        next = _next;
    }
}
