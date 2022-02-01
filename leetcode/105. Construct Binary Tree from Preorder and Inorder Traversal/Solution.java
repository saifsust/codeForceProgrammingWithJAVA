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
    private static int root = 0 ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            index.put(inorder[i], i);
        }
        
        TreeNode tree =null;
        root = 0;
        tree = build(0, inorder.length -1, preorder, index, tree);
        return tree;
    }
    
    private TreeNode build(int first, int last, int[] preorder, Map<Integer, Integer> index, TreeNode tree){
        if(first > last || last < 0) return null;
        tree = new TreeNode(preorder[root]);
        int mid = index.get(preorder[root++]);
        tree.left = build(first, mid - 1, preorder, index, tree.left);
        tree.right = build(mid + 1, last, preorder, index, tree.right);
        return tree;
    }         

}



      
      
