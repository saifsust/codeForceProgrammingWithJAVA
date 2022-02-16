#include <vector>
using namespace std;

vector<int> twoNumberSum(vector<int> array, int targetSum) {
  
	int left = 0, right = array.size() - 1;
	sort(array.begin(), array.end());
	while(left < right){
		int currSum = array[left] + array[right];
		if(currSum == targetSum){
			return {array[left], array[right]};
		}else{
			if(currSum > targetSum){
				right--;
			}else left++;
		}
	}
	
  return {};
}
