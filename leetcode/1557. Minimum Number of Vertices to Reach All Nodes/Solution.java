class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int checker[] = new int[n];
        for(List<Integer> edge : edges){
            checker[edge.get(1)]--;
        }
        List<Integer> vertices = new ArrayList<Integer>();
        for(int i = 0; i<n; i++) if(checker[i] == 0) vertices.add(i);
        return vertices;
    }
    
}
