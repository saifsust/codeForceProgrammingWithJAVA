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
        Map<TreeNode, Integer >level = new HashMap<TreeNode,Integer> ();
        level.put(root, 0);
        while(!Q.isEmpty()){
            TreeNode peek = Q.poll();
            List<Integer> entity = new ArrayList<>();            
            if(peek.left != null){
                level.put(peek.left, level.get(peek) + 1);                
                if(traverse.size() > level.get(peek.left)){
                    List<Integer> temp = traverse.get(level.get(peek.left));
                    temp.add(peek.left.val);
                    traverse.set(level.get(peek.left), temp);   
                }else entity.add(peek.left.val);                
                Q.add(peek.left);
            }
            if(peek.right != null){
                level.put(peek.right, level.get(peek) + 1);
                if(traverse.size() > level.get(peek.right)){
                    List<Integer> temp = traverse.get(level.get(peek.right));
                    temp.add(peek.right.val);
                    traverse.set(level.get(peek.right), temp);
                }else entity.add(peek.right.val);
                Q.add(peek.right);
            }
            
            if(!entity.isEmpty()) traverse.add(entity);
        
        }
        
        return traverse;
    }
}
