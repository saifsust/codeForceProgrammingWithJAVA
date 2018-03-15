import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode();
        rt.push(20);
        rt.push(30);
        rt.push(40);
        rt.push(50);
       TreeNode tr=rt.push(60);
       rt.show(tr);
        System.out.println();
        //rt.traverse();

        TreeNode rt1 = new TreeNode();
        rt1.push(20);
        rt1.push(30);
        rt1.push(400);
        rt1.push(50);
        TreeNode tr2=rt1.push(60);
        //rt1.push(50);
        rt1.show(tr2);
        System.out.println();
        //rt1.traverse();

        Solution sol = new Solution();
        System.out.println(sol.isSameTree(tr, tr2));

    }
}







class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    private TreeNode root;
    private int index;
    TreeNode()
    {
        this.index = 0;
    }
    TreeNode(int x)
    {
        this.val = x;
        this.left = null;
        this.right = null;

        // root = null;
    }
    public TreeNode  push(int x)
    {
        if(root == null)
        {
            this.root = new TreeNode(x);
            index += 1;
        }
        else
        {
            TreeNode tmp = root;
            if(this.index % 2 == 0)
            {
                while(tmp.left != null)tmp = tmp.left;
                tmp.left = new TreeNode(x);
            }
            else
            {
                while(tmp.right != null)tmp = tmp.right;

                tmp.right = new TreeNode(x);
            }
            this.index += 1;
            // System.out.println(index);
            //root =tmp;
        }
        return root;
    }

    public void traverse()
    {
        show(root);
        System.out.println();
    }

    public void show(TreeNode root)
    {
        if(root == null)return ;

        show(root.left);
        System.out.print(" " + root.val);
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
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        int val = treeCheck(p, q);
        //System.out.println(val);
        if(val < 0)return false;

        return true;
    }
    private int treeCheck(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return 0;
        if(p == null && q != null ) return -1;
        if(p != null && q == null)  return -100;
        if(p.val != q.val)          return -2000;
        //System.out.println(p.val + " " + q.val);

        return treeCheck(p.left, q.left) + treeCheck(p.right, q.right);
    }



}