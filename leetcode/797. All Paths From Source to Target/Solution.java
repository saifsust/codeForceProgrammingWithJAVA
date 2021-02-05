class Solution {
    private static List<Integer> entry = new ArrayList<Integer>();
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
            entry.clear();
            entry.add(destination);
            dfs(dest, path, paths);
            
        }
        
        
        return paths;
    }
    
    private void dfs(Integer dest, Set<Integer> path[], List<List<Integer>> paths){
        if(path[dest].contains(-1)){
            entry.add(0,dest);
            paths.add(new ArrayList<Integer>());
            paths.get(paths.size()-1).addAll(entry);
            entry.remove(0);
            return;
        }
        entry.add(0,dest);
        for(Integer next : path[dest]){
             dfs(next, path, paths);   
        }
        entry.remove(0);
        return;
    }
    
  
}
