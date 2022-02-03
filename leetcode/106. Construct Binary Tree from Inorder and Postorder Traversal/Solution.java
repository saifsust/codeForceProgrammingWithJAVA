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
    private static int root = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            index.put(inorder[i], i);
        }
        
        root = postorder.length -1;
        TreeNode tree  = null;
        tree = build(0, postorder.length -1, tree, postorder ,index);
        
        return tree;
    }
    
    
    private TreeNode build(int first, int last, TreeNode tree, int[] postorder , Map<Integer, Integer> index){
        if( first > last || last < 0 || root < 0) return null;
        //System.out.println(root);
       // System.out.println("=== " + first + "  " + last);
         int m = index.get(postorder[root]);
        tree = new TreeNode(postorder[root]);
        root--;
        tree.right = build(m + 1, last, tree.right, postorder ,index);
        tree.left = build(first,  m -1, tree.left, postorder, index);
       
        return tree;
    }
    
}
