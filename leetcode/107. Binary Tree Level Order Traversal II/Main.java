import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2000);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(100);
        //root.right.left = new TreeNode(70);
        //root.right.right = new TreeNode(140);
        TreeNode.show(root);
        System.out.println();
        TreeNode.show(root.left);
        System.out.println();
        Solution sol = new Solution();
        List<List<Integer>> list = sol.levelOrderBottom(root);
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.get(i).size(); j++)
            {
                System.out.print(list.get(i).get(j) + "  ");
            }
            System.out.println();
        }

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


    public static void show(TreeNode root)
    {
        if(root == null) return;
        show(root.left);
        System.out.print(root.val + " ");
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
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();

        TreeNode curr = root;

        Queue<TreeNode>q = new LinkedList<TreeNode>();
        Queue<TreeNode>qq = new LinkedList<TreeNode>();
        q.add(root);
        if(root == null) return result;
        while(!q.isEmpty())
        {
            TreeNode top = q.poll();
            list.add(top.val);
            //System.out.println(top.val);
            if(top.left != null)
            {
                qq.add(top.left);
            }
            if(top.right != null)
            {
                qq.add(top.right);
            }

            if(q.isEmpty())
            {

                while(!qq.isEmpty())
                {
                    q.add(qq.poll());
                }
                result.add(list);
                list = new ArrayList<>();
            }

        }


        List<List<Integer>>revResult = new ArrayList<>();
        /* System.out.println();
         for(int i=0;i<result.size();i++){
             for(int j=0;j<result.get(i).size();j++){
                 System.out.print(result.get(i).get(j)+" ");
             }
             System.out.println();
         }
         System.out.println();*/
        for(int i = result.size() - 1; i >= 0; i--)
        {
            revResult.add(result.get(i));
        }

        return revResult;
    }
}