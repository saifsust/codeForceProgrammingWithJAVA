class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        vector<int> ans;
          for(int j = 0; j<nums[0].size(); j++){
              int val = nums[0][j];
              bool isFound = true;
              for(int k = 1;k<nums.size(); k++){
                  isFound = isExist(val, nums[k]);
                  if(!isFound){
                      break;
                  }
              }
              if(isFound){
                  ans.push_back(val);
              }
          }
        sort(ans.begin(), ans.end());
        return ans;
    }
    
    bool isExist(int val, vector<int>nums){
        for(int i = 0; i< nums.size(); i++){
            if(val == nums[i]) return true;
        }
        
        return false;
    }
};
