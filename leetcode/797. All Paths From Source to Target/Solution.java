class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph.length == 0) return paths;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(0);
        Set<Integer> path[] = new HashSet[graph.length];
        path[0] = new HashSet<Integer>();
        Integer destination = 0;
        path[0].add(-1);
        while(!Q.isEmpty()){
            Integer peek = Q.poll();
            for(Integer next : graph[peek]){
                if(path[next] == null) path[next] = new HashSet<Integer>();
               path[next].add(peek);
                Q.add(next);
                destination = Math.max(destination, next);
            }
        }
        
        for( Integer dest : path[destination]){
            List<Integer> entry = new ArrayList<Integer>();
            entry.add()
        }
        
        
        return paths;
    }
    
    private void dfs(Integer dest, Set<Integer> path[], List<List<Integer>> paths, List<Integer>entry){
        if(path[dest].contains(-1)){
            Collections.reverse(entry);
            paths.add(entry);
            return;
        }
        entry.add(dest);
        for(Integer next : path[dest]){
             dfs(next, path, paths);   
        }
        return;
    }
    
  
}
