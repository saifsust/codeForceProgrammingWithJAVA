/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode > ();
        q1.add(t1);
        q2.add(t2);
        t1.val = t1.val + t2.val;
        while(!q2.isEmpty()){
            TreeNode peek1 = q1.poll();
            TreeNode peek2 = q2.poll();
            if(peek1.left != null && peek2.left != null){
                peek1.left.val = peek1.left.val + peek2.left.val;
                q1.add(peek1.left);
                q2.add(peek2.left);
            }
            
            if(peek1.right != null && peek2.right != null){
                peek1.right.val = peek1.right.val + peek2.right.val;
                q1.add(peek1.right);
                q2.add(peek2.right);
            }
            
            if(peek1.left == null && peek2.left != null){
                peek1.left = new TreeNode(peek2.left.val);
                q1.add(peek1.left);
                q2.add(peek2.left);
            }
            
            if(peek1.right == null && peek2.right != null){
                peek1.right = new TreeNode(peek2.right.val);
                q1.add(peek1.right);
                q2.add(peek2.right);
            }
            
        }
        
        
        return t1;
    }
}
