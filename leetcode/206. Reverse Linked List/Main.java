import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        ListNode node = ListNode.add(1);
        ListNode.add(2);
        ListNode.add(3);
        ListNode.add(4);
        ListNode.add(5);
        ListNode.show(node);


        ListNode rev = sol.reverseList(node);
        ListNode.show(rev);


    }
}

class ListNode
{
    int val;
    ListNode next;
    private static ListNode root;
    ListNode(int x)
    {
        this.val = x;
        this.next = null;
    }


    public static ListNode add(int x)
    {
        if(root == null) root = new ListNode(x);
        else
        {
            ListNode head = root;
            while(head.next != null) head = head.next;
            head.next = new ListNode(x);
        }
        return root;
    }
    public static void show(ListNode root)
    {
        System.out.println("================ Linked List =============");
        while(root != null)
        {
            System.out.print(root.val + "  ");
            root = root.next;
        }
        System.out.println();


    }


}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution
{
    public ListNode reverseList(ListNode head)
    {
        if(head == null) return head;
        
        ListNode rev = null, next = null, root = head;
        while(root != null)
        {
        	//System.out.println(root.val);
            next = root.next;
            root.next = rev;
            rev = root;
            root = next;
        }

        //ListNode.show(rev);

        return rev;
    }
}