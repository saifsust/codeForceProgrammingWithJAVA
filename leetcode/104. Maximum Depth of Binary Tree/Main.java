import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
    	Solution sol = new Solution();
        TreeNode root = new TreeNode(20000);
        root.left = new TreeNode(30);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(60);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(80);
        TreeNode.traverse(root);
        System.out.println();
        System.out.println(sol.maxDepth(root));
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

    public static void traverse(TreeNode root)
    {
        if(root == null)return;
        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
    }
}

class Solution
{
   
    public int maxDepth(TreeNode root)
    {
        if(root == null)return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }



}