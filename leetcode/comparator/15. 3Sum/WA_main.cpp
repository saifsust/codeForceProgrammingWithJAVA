class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        
        set<vector<int>, comparator> temp;
        
         int start = 0, end = nums.size() - 1;
         
         while(start  < end ){
             int sum = nums[start] + nums[end];
             //cout << sum << endl;
             int idx = binarySearch(start + 1, end - 1, nums, sum != 0 ? -1 * sum : 0);
             if(idx != -1){
                if(nums[start] + nums[idx] + nums[end] == 0){
                   temp.insert({nums[start], nums[idx], nums[end]});
                }
             }
             
             if(sum< 0) start++;
             else end--;
         }
        
        vector<vector<int>> ans;
        for(auto val : temp){
            ans.push_back(val);
        }
        sort(ans.begin(), ans.end(), [](vector<int> &a, vector<int> &b){
            return a[0] > b[0] | a[1] > b[1] | a[2] > b[2];
        });
        return ans;        
    }
    
    int binarySearch(int first, int last, vector<int> nums, int key){
        if(first > last) return -1;
        int mid = (first + last) >> 1;
        if(nums[mid] == key) return mid;
        else if(nums[mid] > key) return binarySearch(first, mid - 1, nums, key);
        else return binarySearch(mid + 1, last, nums, key);
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
