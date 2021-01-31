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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traverse = new ArrayList<List<Integer>>();
        if(root == null) return traverse;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        traverse.add(Arrays.asList(root.val));
        Map<TreeNode, Integer> depth = new HashMap<TreeNode, Integer>();
        depth.put(root, 0);
        while(!Q.isEmpty()){
            TreeNode peek = Q.poll();
            List<Integer> entry = new ArrayList<Integer>();
            Integer level = depth.get(peek);
            if(peek.left != null){
                depth.put(peek.left , level + 1);
                Q.add(peek.left);
                entry.add(peek.left.val);
            }
            if(peek.right != null){
                depth.put(peek.right, level + 1);
                Q.add(peek.right);
                entry.add(peek.right.val);
            }
            
            if(!entry.isEmpty()){
                if((depth.get(peek)+ 1) % 2 == 1){
                    Collections.reverse(entry);
                    if(traverse.size() > depth.get(peek) + 1){
                        for(int i = entry.size()-1; i>=0; i--){
                            traverse.get(depth.get(peek)+1).add(0,entry.get(i));
                        }
                    }else traverse.add(entry);
                    
                }else{
                     
                    if(traverse.size() > depth.get(peek) + 1){
                         traverse.get(depth.get(peek) + 1).addAll(entry);
                     }else traverse.add(entry);
                }
            }
        }
        return traverse;
    } 
    
}
