import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main(String[] args)
    {

        //First Test case
        TreeNode node= new TreeNode(1);
        /* node.left = new TreeNode(2);
         node.left.left = new TreeNode(3);
         node.left.left.left = new TreeNode(4);
         node.right = new TreeNode(2);
         node.right.left = new TreeNode(3);
         node.right.right = new TreeNode(3);*/
        //Second Test Case
        // node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(4);


        System.out.println("=========== Traverse ==========");
        //TreeNode.display(node);
        System.out.println();

        Solution sol = new Solution();
        System.out.println("Result : " + sol.minDepth(node));

    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x)
    {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public static void display(TreeNode root)
    {
        if (root == null) return;
        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

}

class Solution
{

    private int left, right;
    public int minDepth(TreeNode root)
    {
        if(root == null)return 0;
        //System.out.print(root.val + " ");
        if(root.left == null && root.right == null) return 1;
        if(root.right == null)
            return  minDepth(root.left) + 1;
        if(root.left == null)
            return minDepth(root.right) + 1;

        //System.out.println("DONE");
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}