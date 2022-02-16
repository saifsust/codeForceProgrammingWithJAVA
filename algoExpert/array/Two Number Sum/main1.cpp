#include <vector>
using namespace std;

vector<int> twoNumberSum(vector<int> array, int targetSum) {
  vector<int> ans;
	for(int i = 0; i< array.size(); i++){
		 int val = array[i];
		  for(int  j = i + 1 ; j< array.size(); j++){
				 if(targetSum - val == array[j]){
					  ans.push_back(val);
					 ans.push_back(array[j]);
					 break;
				 }
			}
		if(!ans.empty()){
			return ans;
		}
	}
  return ans;
}
