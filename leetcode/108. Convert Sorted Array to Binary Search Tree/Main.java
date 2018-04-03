import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(200);
        node.left = new TreeNode(100);
        node.right = new TreeNode(30);
        TreeNode.display(node);

        Scanner read = FileFactory.read();

        int num = read.nextInt();

        int[] nums = new int[num];

        for(int i = 0; i < num; i++)
        {
            nums[i] = read.nextInt();
        }
        System.out.println();
        for(int i = 0; i < num; i++)System.out.print(nums[i] + " ");
        System.out.println();

        FileFactory.close();

        Solution sol = new Solution();
        TreeNode root = sol.sortedArrayToBST(nums);
        TreeNode.display(root);

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
        if (root == null) return;
        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TrhieeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
       TreeNode root = binaryTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode binaryTree(int[] nums, int start , int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;


        int val = nums[mid];

        TreeNode head = new TreeNode(val);
        head.left = binaryTree(nums, start, mid - 1);
        head.right = binaryTree(nums, mid + 1, end);
        return head;

    }
}