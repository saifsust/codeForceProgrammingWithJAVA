import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        TreeNode root = new TreeNode();
        root = root.push(1);
        root.push(2);
        root.push(2);
        root.push(3);
        root.push(3);

        TreeNode.show(root);
        System.out.println();
        System.out.println(sol.isSymmetric(root));



    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    private static  int index = 0;
    private  static TreeNode  head;
    TreeNode()
    {
        head = null;
    }

    TreeNode(int x)
    {
        this.val = x;
        left = null;
        right = null;

    }


    public  TreeNode push(int x)
    {

        if(head == null)
        {
            head = new TreeNode(x);
        }
        else
        {
            TreeNode temp = head;
            if(index % 2 == 0)
            {
                while(temp.left != null) temp = temp.left;
                temp.left = new TreeNode(x);
            }
            else
            {
                while(temp.right != null) temp = temp.right;
                temp.right = new TreeNode(x);
            }
        }
        index++;
        return head;


    }

    public static void show(TreeNode root)
    {
        if(root == null) return ;
        System.out.print(root.val + " ");
        show(root.left);
        show(root.right);
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
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isSymm(root.left, root.right);
    }

    private boolean isSymm(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;

        if( left != null && right != null &&   left.val == right .val)
            return isSymm(left.left, right.right) && isSymm(left.right, right.left);
        return false;
    }




}