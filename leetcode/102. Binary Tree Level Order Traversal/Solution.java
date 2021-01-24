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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        List<List<Integer>> traverse = new ArrayList<>();
        if(root == null) return traverse;
        traverse.add(Arrays.asList(root.val));
        Q.add(root);
        while(!Q.isEmpty()){
            TreeNode peek = Q.poll();
            List<Integer> entity = new ArrayList<>();
            if(peek.left != null){
                entity.add(peek.left.val);
                Q.add(peek.left);
            }
            if(peek.right != null){
                entity.add(peek.right.val);
                Q.add(peek.right);
            }
            if(!entity.isEmpty()) traverse.add(entity);
        }
        
        return traverse;
    }
}
