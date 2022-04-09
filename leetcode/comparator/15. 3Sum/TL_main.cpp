class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>, comparator> temp;
        for(int i = 0; i<nums.size() - 2; i++){
            for(int j = i + 1 ; j<nums.size() - 1; j++){
                for(int k = j + 1; k < nums.size(); k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        temp.insert({nums[i], nums[j], nums[k]});
                    }
                }
            }
        }
        
        vector<vector<int>> ans;
        for(auto val : temp){
            ans.push_back(val);
        }
        
        return ans;        
    }
    
    struct comparator{
      bool operator()(const vector<int> &a, const vector<int> &b) const{
             if(a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) return false;
             if(a[0] == b[0] && a[1] == b[2] && a[2] == b[1]) return false;
            
             if(a[0] == b[1] && a[1] == b[0] && a[2] == b[2]) return false;
             if(a[0] == b[1] && a[1] == b[2] && a[2] == b[0]) return false;
            
             if(a[0] == b[2] && a[1] == b[0] && a[2] == b[1]) return false;
             if(a[0] == b[2] && a[1] == b[1] && a[2] == b[0])  return false;
             return true;
      }  
    };
    
};
