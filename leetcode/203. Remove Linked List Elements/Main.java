import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        ListNode node = ListNode.add(1);
           ListNode.add(1);
           ListNode.add(1);
           ListNode.add(1);
           ListNode.add(2);
           ListNode.add(6);
           ListNode.add(3);
           ListNode.add(1);
           ListNode.add(4);
           ListNode.add(5);
           ListNode.add(6);
           ListNode.add(1);
           ListNode.add(7);


     /*   ListNode node =  ListNode.add(1);
        ListNode.add(2);
        ListNode.add(3);
        ListNode.add(2);
        ListNode.add(1);
        ListNode.add(2);*/
        ListNode.show(node);
        Solution sol = new Solution();
        ListNode rNode = sol.removeElements(node, 6);
        ListNode.show(rNode);


    }
}

class ListNode
{
    int val;
    ListNode next;
    private static ListNode  root;
    ListNode(int x)
    {
        this.val = x;
        this.next = null;

    }
    public static ListNode add(int x)
    {
        if(root == null)
        {
            root = new ListNode(x);
        }
        else
        {
            ListNode head = root;
            while(head.next != null)
            {
                head = head.next;
            }
            head.next = new ListNode(x);
        }
        return root;

    }
    public static void show(ListNode root )
    {
        ListNode head = root;
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }
}
class Solution
{
    public ListNode removeElements(ListNode head, int val)
    {

        if(head == null)return head;
        while( head != null)
        {
            if(head.val == val)
                head = head.next;
            else break;
        }
        ListNode root = head;
        if(head == null)return head;
        ListNode next = null, prev = null;
    
        prev = root;
        while(root != null)
        {
            //prev = root;
            //System.out.println("Done");
            if(root.next != null && root.next.val == val)
            {
                prev = root.next;
                while(prev != null)
                {
                    if(prev.val == val)
                        prev = prev.next;
                    else break;
                }
                root.next = prev;
                continue;
            }
            root = root.next;

        }

        return head;
    }
}