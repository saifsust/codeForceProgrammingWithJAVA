import java.util.*;
import java.lang.*;
import java.io.*;
public class LinkedList
{
    private ListNode head, temp;

    public LinkedList()
    {
        head = null;
        temp = null;
    }

    /*** Add data into linked List ****/
    public void add(int x)
    {
        if(head == null)
        {
            head = new ListNode(x);
            head.next = null;
        }
        else
        {
            ListNode node = head;
            while(node.next != null)
            {
                node = node.next;
            }
            node.next = new ListNode(x);
        }
    }


    /****** display all data from linked List ****/

    public void show()
    {
        ListNode node = head;
        while(node != null)
        {
            System.out.print(node.getVal() + " ");
            node = node.next;

        }
        System.out.println();
    }

    /** add front of the List **/
    public void push_front(int x)
    {

        ListNode temp = new ListNode(x);
        temp.next = head;
        head = temp;

    }

    /*** get size of the list ***/
    public int size()
    {
        int _size = 0;
        ListNode tmp = head;
        while(tmp != null)
        {
            _size++;
            tmp = tmp.next;
        }
        return _size;
    }


    /**get data using index ***/
    public int get(int index)
    {

        int ind = 0;
        ListNode tmp = head;
        while(tmp != null)
        {
            if(ind == index)
            {
                return tmp.getVal();
            }
            ind++;
            tmp = tmp.next;
        }
        return -1;

    }


    /*** insert into specific position **/
    public void insertAt(int x, int index)
    {
        ListNode tmp = head;
        ListNode node = new ListNode(x);
        int ind = 0;
        while(tmp != null && ind != index)
        {

            tmp = tmp.next;
            ind++;

        }

        ListNode n = tmp.next;
        System.out.println(n.getVal());
        tmp.next = node;
        tmp.next.next = n;
    }





}