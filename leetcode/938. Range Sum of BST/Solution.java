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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        int sum = 0;
        while(!Q.isEmpty()){
            TreeNode peek = Q.poll();
            if(peek.val >= low && peek.val <= high) sum += peek.val;
            if(peek.left != null){
                Q.add(peek.left);
            }
            if(peek.right != null){
                Q.add(peek.right);
            }
        }
        
        return sum;
    }
}
