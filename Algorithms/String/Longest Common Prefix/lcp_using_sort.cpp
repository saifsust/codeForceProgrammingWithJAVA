#include<bits/stdc++.h>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n;
	while(cin>> n){
		string arr[n];
		for(int i =0; i<n; i++) cin >> arr[i];
		sort(arr, arr+n);
		int length = min(arr[0].size(), arr[n-1].size());
		string temp = "";
		for(int i = 0; i<length; i++){
			if(arr[0][i] != arr[n-1][i])break;
			temp.push_back(arr[0][i]);
		}
		cout << (temp.compare("") == 0 ? "-1" : temp) << endl;
		
	}
	
	return 0;
}
