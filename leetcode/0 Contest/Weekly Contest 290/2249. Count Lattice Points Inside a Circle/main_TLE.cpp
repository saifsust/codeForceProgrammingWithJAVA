class Solution {
public:
    int dx[8] = {-1, 1, 1, -1, 0, 0, 1,-1};
    int dy[8] = {-1,-1, 1, 1, 1, -1, 0, 0};
    map<pair<int, int>, bool> visited;
    
    void dfs(int x, int y, int a, int b , int r , set<pair<int, int>> &coordinates){
        int  val = pow(abs(x - a), 2) + pow(abs(y - b), 2);
        if( val <= r * r){
            coordinates.insert({x, y});
            for(int i = 0; i< 8; i++){
                int idx = x + dx[i];
                int idy = y + dy[i];
                if(visited[{idx, idy}] == false){
                    visited[{idx, idy}] = true;
                    dfs(idx, idy, a, b, r, coordinates);
                }
               
            }
            
        }
    }
    int countLatticePoints(vector<vector<int>>&circles) {
        const int N = 101;
        set<pair<int, int>> coordinates;
        
        for(auto circle : circles){
            int r = circle[2];
            int x = circle[0];
            int y = circle[1];
            visited.clear();
            
            dfs(x, y , x, y, r, coordinates);
            
        }
        
        
        return coordinates.size();
        
    }
};
