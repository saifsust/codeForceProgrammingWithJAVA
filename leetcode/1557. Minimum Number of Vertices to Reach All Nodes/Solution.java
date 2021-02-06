class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> minVertex = new ArrayList<Integer>();
        Integer len = Integer.MAX_VALUE;
        for(int source = 0; source<n; source++){
           boolean visited[] = new boolean[n+1];
            List<Integer> entry = new ArrayList<Integer>();
            for(int start = source; start< n; start++){
                if(visited[start]) continue;
                 entry.add(start);
                 dfs(start, visited, edges);
            }
            if(len > entry.size()){
               len = entry.size();
                minVertex.clear();
                minVertex.addAll(entry);
            }
        }
        
        return minVertex;
    }
    private void dfs(int source, boolean visited[], List<List<Integer>> edges){
         visited[source] = true;
         for(List<Integer> next : edges){
             if(next.get(0) == source){
                 if(visited[next.get(1)]) continue;
                 dfs(next.get(0), visited, edges);
             }
             
         }
    }
}
