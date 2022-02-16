#include <vector>
using namespace std;
// time Complexity is O(n)
vector<int> twoNumberSum(vector<int> array, int targetSum) {
  unordered_set<int> nums;
  for(int i = 0; i< array.size(); i++){
		 int val = targetSum - array[i];
		 if(nums.find(val) != nums.end()){
			 return {val,array[i]};
		 }else{
			 nums.insert(array[i]);
		 }
	}
	
  return {};
}
