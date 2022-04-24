class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>&rectangles, vector<vector<int>>&points) {
        vector<int> counter;
        const int N = 102;
        vector<vector<int>> xx(N);
        for(vector<int> rectangle : rectangles){
            xx[rectangle[1]].push_back(rectangle[0]);
        }
        
        for(int i = 0; i<N; i++){
            sort(xx[i].begin(), xx[i].end());
        }
        
        for(vector<int> point : points){
            int x = point[0];
            int sum = 0;
            for(int y = point[1]; y <xx.size(); y++){
                if(xx[y].empty()){
                    continue;
                }
                
                sum += xx[y].size() - lower_bound(0, xx[y].size()-1, x, xx[y]);  
            }
            counter.push_back(sum);
        }
        
        return counter;
    }
    
    
    // greater or equal own implementation
    
    int lower_bound(int first , int last, int val, vector<int> &xx){
        if(val > xx[xx.size()-1]) return xx.size();
        if(first == last) return first;
        int mid = (first + last) >> 1;
        if(xx[mid] < val){
            return lower_bound(mid + 1, last, val, xx);
        }else{
            return lower_bound(first, mid, val, xx);
        }
    }
    
    
};
