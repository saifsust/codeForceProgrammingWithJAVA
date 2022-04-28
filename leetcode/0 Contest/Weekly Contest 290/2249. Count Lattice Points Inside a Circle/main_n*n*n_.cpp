class Solution {
public:
    int countLatticePoints(vector<vector<int>>&circles) {
        const int N = 202;
        int grid[N][N];
        for(int i = 0; i<N; i++){
            memset(grid[i], 0, sizeof(grid[i]));
        }
        
        long long ans = 0;
        for(auto circle : circles){
            for(int dx = -circle[2]; dx<= circle[2]; dx++){
                for(int dy = -circle[2]; dy <= circle[2]; dy++){
                    if(dx * dx + dy * dy <= circle[2] * circle[2]){
                        ans += ++grid[dx + circle[0]][dy + circle[1]] == 1;
                    }
                }
            }
        }
        return ans;
    }
};
