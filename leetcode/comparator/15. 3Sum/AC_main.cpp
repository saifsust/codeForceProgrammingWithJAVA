class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        set<vector<int>> uniques;
        
        for(int i = 0; i< nums.size(); i++){
            
            if(i> 0 && nums[i] == nums[i-1]) continue;
            
            int left = i + 1, right = nums.size() - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0){
                    uniques.insert({nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                }
                if(sum < 0) left++;
                if(sum > 0) right--;   
            }
        }
        
        vector<vector<int>> ans;
        for(auto val : uniques){
            ans.push_back(val);
        }
        
        return ans;        
    }
    
   
    
 
};
