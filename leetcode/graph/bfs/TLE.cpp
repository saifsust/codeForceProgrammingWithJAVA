class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if(n == 1 || edges.empty()) return {0};
        vector<int> graph[n];
       
       for(auto next : edges){
           graph[next[0]].push_back(next[1]);
           graph[next[1]].push_back(next[0]);
       }

       vector<pair<int,int>> pairs;
     
       for(int i = 0; i<n; i++){
           pairs.push_back(bfs(n, i, graph));
       }

       sort(pairs.begin(), pairs.end(), [&](const pair<int,int> a, const pair<int,int> b){
           return a.first < b.first;
       });

       vector<int> ans;
       ans.push_back(pairs[0].second);
       
       for(int i = 1; i < (int)pairs.size() && pairs[0].first == pairs[i].first; i++){
           ans.push_back(pairs[i].second);
       }
       return ans;
    }

    pair<int, int> bfs(int n, int source, vector<int> graph[]){
        queue<int> Q;
        Q.push(source);
        const int INF = (int) 1e8;
        vector<int> heights(n, INF);
        heights[source] = 0;
        while(!Q.empty()){
            int pnt = Q.front();
            Q.pop();
            for(int next : graph[pnt]){
              int h = heights[pnt] + 1; 
              if(h <= heights[next]){
                  heights[next] = h;
                  Q.push(next);
              }
            }
        }
        return make_pair(getMax(heights),source);
    }

    int getMax(vector<int> heights){
        int mx = 0;
        for(int h : heights){
            if(mx < h) mx = h;
        }
        return mx;
    }

};
