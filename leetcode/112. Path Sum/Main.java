import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);

        //Test Case
        /*   TreeNode node = new TreeNode(1);
           node.left = new TreeNode(2);*/


        System.out.println("======== Tree Traverse ======");
        TreeNode.show(node);
        System.out.println();
        Solution sol = new Solution();
        System.out.println(sol.hasPathSum(node, 21));


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


    static void show(TreeNode root)
    {
        if(root == null)return;
        show(root.left);
        System.out.print(root.val + "  ");
        show(root.right);
    }

}
class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null) return false;
        return Traverse(root, sum);

    }
    private boolean Traverse(TreeNode root, int sum)
    {
        //System.out.println(root.val+" "+sum)

        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        if(root.left == null && root.right == null && sum - root.val != 0) return false;
        if(root.left == null)return Traverse(root.right, sum - root.val);
        if(root.right == null) return Traverse(root.left, sum - root.val);
        /*
        if(root == null && sum == 0) return true;
        if(root == null && sum != 0 )return false;*/

        return Traverse(root.left, sum - root.val) || Traverse(root.right, sum - root.val);
    }
}