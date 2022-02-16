package Add_Two_Numbers_1;

public class Node {

    public int val;
    public Copy_List_with_Random_Pointer_2.Node next;
    public Copy_List_with_Random_Pointer_2.Node random;

    public Node(int val) {
    }

    public Node(int _val, Copy_List_with_Random_Pointer_2.Node _next, Copy_List_with_Random_Pointer_2.Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
