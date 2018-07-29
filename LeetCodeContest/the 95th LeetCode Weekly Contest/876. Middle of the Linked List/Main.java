

class Main
{
    public static void main(String[] args)
    {

    }
}

//Definition for singly-linked list.
public class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}
class Solution
{
    public ListNode middleNode(ListNode head)
    {
        ListNode root = head;
        int size = 0;
        while(root != null)
        {
            ++size;
            root = root.next;
        }

        root = head;
        int mid = (int)size / 2;
        int count = 0;
        while(root.next != null)
        {
            if(count == mid)
            {
               // root.next = null;
                return root;

            }
            ++count;
            root = root.next;
        }
        return root;

    }
}