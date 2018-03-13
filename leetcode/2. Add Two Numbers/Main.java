import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] num = {0, 0, 0, 0};
        int[] num2 = {0, 0, 0, 0};
        ListNode node1 = ListNode.push_num(num);
        node1.show();
        ListNode node2 = ListNode.push_num(num2);
        node2.show();
        ListNode sum = sol.addTwoNumbers(node1, node2);
        sum.show();


    }
}





class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }



    public static ListNode push_num(int[] num)
    {
        ListNode node = null;
        if(num.length > 0)
            node = new ListNode(num[0]);
        for(int i = 1; i < num.length; i++)
        {
            node.push_front(num[i]);
        }
        return node;
    }

    public void push_front(int x)
    {
        if(this.next == null) next = new ListNode(x);
        else
        {
            ListNode xx = this.next;
            while(xx.next != null) xx = xx.next;
            xx.next = new ListNode(x);
        }
    }

    public void show()
    {
        ListNode xx = this;
        if(xx == null) return;
        while(xx != null)
        {
            System.out.print(xx.val + "  ");
            xx = xx.next;
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
    private ListNode num = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode temp = null;
        ListNode num1 = l1;
        ListNode num2 = l2;
        int carry = 0;
        while(num1 != null && num2 != null)
        {
            int val1 = num1.val;
            int val2 = num2.val;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            insert(sum % 10);
            num1 = num1.next;
            num2 = num2.next;

        }
        if(num1 != null )
        {
            while(num1 != null)
            {
                int sum = carry + num1.val;
                carry = sum / 10;
                insert(sum % 10);
                num1 = num1.next;
            }
        }
        if(num2 != null)
        {
            while(num2 != null)
            {
                int sum = carry + num2.val;
                carry = sum / 10;
                insert(sum % 10);
                num2 = num2.next;
            }
        }

        if(carry > 0 )
        {
            insert(carry);
        }

        ListNode xx = num;
        int val = 0;
        while(xx != null)
        {
            val = xx.val;
            xx = xx.next;
            if(val == 0)
            {
                continue;
            }
            else break;
        }
        if(xx == null && val == 0)return new ListNode(0);

        return num;
    }

    private  void insert(int val)
    {

        if(num == null )num = new ListNode(val);
        else
        {
            ListNode xx = num;
            while(xx.next != null) xx = xx.next;
            xx.next = new ListNode(val);


        }
    }
}