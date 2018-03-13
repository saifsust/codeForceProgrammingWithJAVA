import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<Integer>list = new ArrayList<Integer>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(40);
        list.add(40);
        ListNode node = ListNode.pushList(list);
        node.show();
        ListNode head = sol.deleteDuplicates(node);
        head.show();

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


class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        this.val = x;
    }



    public static ListNode pushList(List<Integer > list)
    {
        ListNode node = new ListNode(list.get(0));
        for(int i = 1; i < list.size(); i++)
        {
            node.push_front(list.get(i));
        }
        return node;
    }




    void push_front(int x)
    {
        if(this.next == null)
        {
            this.next = new ListNode(x);
            this.next.next = null;
        }

        else
        {
            ListNode xx = this.next;
            while(xx.next != null)xx = xx.next;
            xx.next = new ListNode(x);
            xx.next.next = null;
        }
    }

    void show()
    {
        ListNode xx = this;
        while(xx != null)
        {
            System.out.print(xx.val + "  ");
            xx = xx.next;
        }
        System.out.println();
    }


}

class Solution
{
    private ListNode temp = null;
    public ListNode deleteDuplicates(ListNode head)
    {

        ListNode xx = head;
        int prev = Integer.MIN_VALUE;
        while(xx != null)
        {
            int val = xx.val;
            xx = xx.next;
            if(xx != null && val == xx.val)
                continue;
            insert(val);

        }

        return temp;
    }

    private void insert(int val)
    {
        if(temp == null)
        {
            temp = new ListNode(val);
        }
        else
        {
            ListNode yy = temp;
            while(yy.next != null) yy = yy.next;
            yy.next = new ListNode(val);
        }

    }

}