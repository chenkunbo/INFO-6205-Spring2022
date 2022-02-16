package com.company;

import org.w3c.dom.Node;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


    }

    // 2. Add Two Numbers
    /* Definition for singly-linked list.
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
     */
    private static ListNode addTwoNumbers(LinkList l1, LinkList l2){
        int v1 = 0;
        int v2 = 0;
        int sum = 0;
        int carry = 0;
        ListNode sumHead = new ListNode(-1);
        ListNode ptr = sumHead;
        while(l1 != null || l2 != null){
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            else v1 = 0;
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            else v2 = 0;
            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            ptr.next = temp;
            ptr = ptr.next;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            ptr.next = temp;
        }
        return sumHead.next;
    }


    // 138. Copy List with Random Pointer.
    // define a Node class
    public Node copyRandomList(Node head){
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
    }






}
