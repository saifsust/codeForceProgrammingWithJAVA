#include<bits/stdc++.h>
using namespace std;

unsigned minLen(string arr[], int n){
	unsigned mn = INT_MAX;
	for(int i = 0; i< n; i++) mn = min(mn, (unsigned )arr[i].size());
	return mn;
}

bool isContain(string arr[], int n, int start, int end){
	for(int i = 0; i < n -1 ; i++){
		for(int j = start; j<= end; j++){
			if(arr[i][j] != arr[i+1][j]) return false;
		}
	}
	return true;
}
string longestCommonPrefix(string arr[], int n){
	string prefix="";
	unsigned min_len = minLen(arr, n);
	unsigned low = 0, high = min_len - 1;
	while(low <= high){
		int mid = (low + high) >> 1;
		//cerr << mid << endl; 
		if(isContain(arr, n, low, mid)){
			prefix += arr[0].substr(low, mid - low + 1);
			low = mid + 1;
		}else high = mid - 1;
	}
	return prefix;
}


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n;
	while(cin >> n){
		string arr[n];
		for(int i = 0; i<n; i++) cin >> arr[i];
		cout << longestCommonPrefix(arr, n) << endl;	
	}
	return 0;
}
