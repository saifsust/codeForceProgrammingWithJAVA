import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {

        // First Test Case

        /*  int x = 1;
          TreeNode node = new TreeNode(x);
          node.left =  new TreeNode(x * 2);
          node.right = new TreeNode(x * 3);
          node.left.left = new TreeNode(node.left.val * 2);
          node.left.right = new TreeNode(node.left.val * 3);
          node.right.left = new TreeNode(node.right.val * 2);
          node.right.right = new TreeNode(node.right.val * 3);
          node.left.left.left = new TreeNode(node.left.left.val * 2);
          node.left.left.right = new TreeNode(node.left.left.val * 3);*/



        //second Test Case

        /*   TreeNode node = new TreeNode(3);
           node.left = new TreeNode(9);
           node.right = new TreeNode(20);
           node.right.left = new TreeNode(15);
           node.right.right = new TreeNode(7);*/

        // Third Test Case
       /*  TreeNode node = new TreeNode(1);
         node.left = new TreeNode(2);
         node.right = new TreeNode(2);
         node.left.left = new TreeNode(3);
         node.left.right = new TreeNode(3);
         node.left.left.left = new TreeNode(4);
         node.left.left.right = new TreeNode(4);*/
        

        // Fourth Test Case
        /*   TreeNode node = new TreeNode(1);
           node.right = new TreeNode(2);
           node.right.right = new TreeNode(3);*/

        //fifth Test Case

        /*TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.right.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.right.right.right = new TreeNode(4);*/


        TreeNode.display(node);
        System.out.println();
        System.out.println("======= Tree Traverse =====");
        Solution sol = new Solution();
        System.out.println(sol.isBalanced(node));

    }
}



class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public static void display(TreeNode root)
    {

        if(root == null) return;
        display(root.left);
        System.out.print(root.val + "  ");
        display(root.right);
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    public boolean isBalanced(TreeNode root)
    {
        if(root == null) return true;

        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        int left = 0 , right = 0;
        while(!Q.isEmpty())
        {

            TreeNode peek = Q.poll();
            if(peek.left != null)
            {
                Q.add(peek.left);

            }
            if(peek.right != null)
            {
                Q.add(peek.right);

            }
            right = heigth(peek.right);
            left = heigth(peek.left);

           // System.out.println(left + " " + right);
            if(Math.abs(left - right) >= 2)return false;

        }

        /*  int left = heigth(root.left);
          int right = heigth(root.right);
          //System.out.println(left+"  "+right);
          if(Math.abs(left - right) <= 1)return true;
          //System.out.println(left + " " + right)*/;
        return true;

    }

    private int heigth(TreeNode root)
    {

        if(root == null) return 0;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Queue<TreeNode> QQ = new LinkedList<TreeNode>();

        int heigth = 1;
        Q.add(root);
        while(!Q.isEmpty())
        {
            TreeNode peek = Q.poll();
            //System.out.print(peek.val + " ");

            if(peek.left != null)
            {
                QQ.add(peek.left);
            }
            if(peek.right != null)
            {
                QQ.add(peek.right);
            }
            if(Q.isEmpty() && !QQ.isEmpty())
            {
                //System.out.println("H => " + heigth);
                while(!QQ.isEmpty())
                {
                    Q.add(QQ.poll());
                }
                heigth += 1;
            }



        }
        /*  System.out.println();
          System.out.println(heigth);*/

        return heigth;
    }

}