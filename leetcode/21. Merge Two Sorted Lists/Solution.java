public class Solution
{





    public static void main(String[] args)
    {
        ListNode node = new ListNode(12);
        node.push_back(13);
        node.push_back(14);
        node.push_back(134);
        ListNode node2 = new ListNode(2);
        node2.push_back(5);
        node2.push_back(12);
        node2.push_back(100);
        node2.push_back(200);
        //node.show();

        System.out.println("Node 1");
        ListNode node3 = node;
        while(node3 != null)
        {
            System.out.print(node3.val + " ");
            node3 = node3.next;
        }
        System.out.println();

        System.out.println("Node 2");

        ListNode node4 = node2;
        while(node4 != null)
        {
            System.out.print(node4.val + " ");
            node4 = node4.next;
        }
        ListNode nnn =null;
        ListNode temp = new Solution().mergeTwoLists(nnn, nnn);
        System.out.println();
        System.out.println("Merge Nodes node And Node2");
        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    static  class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            this.val = x;
        }


        public void push_back(int x)
        {
            if(this == null)
            {
                next = new ListNode(x);
            }
            else
            {
                ListNode temp = this;
                while(temp.next != null)
                {
                    temp = temp.next;
                }
                ListNode node = new ListNode(x);
                temp.next = node;

            }


        }



        public void show()
        {
            ListNode node = this;
            while(node != null)
            {
                System.out.print(node.val + "  ");
                node = node.next;
            }
            System.out.println();
        }



    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode temp = null ;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {

                if(temp == null)
                {
                    temp = new ListNode(l1.val);
                }
                else
                {
                    ListNode n = temp;
                    while(n.next != null)
                    {
                        n = n.next;
                    }
                    n.next = new ListNode(l1.val);
                }

                l1 = l1.next;
            }
            else
            {
                if(temp == null)
                {
                    temp = new ListNode(l2.val);
                }
                else
                {
                    ListNode n = temp;
                    while(n.next != null)
                    {
                        n = n.next;
                    }
                    n.next = new ListNode(l2.val);
                }
                l2 = l2.next;
            }
        }



        if(l1 == null)
        {


            while(l2 != null)
            {

                if(temp == null)
                {
                    temp = new ListNode(l2.val);
                }
                else
                {

                    ListNode n = temp;
                    while(n.next != null)
                    {
                        n = n.next;
                    }
                    n.next = new ListNode(l2.val);
                }
                l2 = l2.next;
            }



        }

        if(l2 == null)
        {
            while(l1 != null)
            {

                if(temp == null)
                {
                    temp = new ListNode(l1.val);
                }
                else
                {

                    ListNode n = temp;

                    while(n.next != null)
                    {
                        n = n.next;
                    }
                    n.next = new ListNode(l1.val);
                }
                l1 = l1.next;

            }
        }




        return temp;
    }
}