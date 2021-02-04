/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> Q = new LinkedList<Node>();
        Map<Node, Integer > depth = new HashMap<Node, Integer>();
        depth.put(root, 1);
        Q.add(root);
        Integer mx = 1;
        while(!Q.isEmpty()){
            Node peek = Q.poll();
            for(Node next : peek.children){
                Q.add(next);
                depth.put(next, depth.get(peek) + 1);
                mx = Math.max(mx, depth.get(next));
            }
        }
        return mx;
    }
}
