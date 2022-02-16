#include <vector>
using namespace std;

int binarySearch(int first, int last, int key, vector<int> array){
	  if(first > last || last < 0) return -1;
	  int mid  = (first + last) >> 1;
	  if(array[mid] == key){
			return mid;
		} 
	  else{
			if(array[mid] < key) return binarySearch(mid + 1, last, key, array);
			else return binarySearch(first, mid -1, key, array);
		}
}

vector<int> twoNumberSum(vector<int> array, int targetSum) {
  // Write your code here.
	sort(array.begin(), array.end());
	vector<int> ans;
	for(int i = 0; i< array.size(); i++){
		int val = array[i];
		int search = binarySearch(0, array.size()-1, targetSum - val, array);
		if(search != -1 && search != i){
			ans.push_back(val);
			ans.push_back(array[search]);
			break;
		}
	}
	
  return ans;
}

