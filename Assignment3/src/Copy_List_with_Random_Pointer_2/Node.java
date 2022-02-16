package Copy_List_with_Random_Pointer_2;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val){}

    public Node(int _val, Node _next, Node _random){
        val = _val;
        next = _next;
        random = _random;

    }
}
