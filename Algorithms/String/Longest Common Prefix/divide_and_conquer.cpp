#include<bits/stdc++.h>
using namespace std;
string divideConquer(int first, int last, string arr[]){
	if(first == last ) return arr[first];
	int mid = (first + last) >> 1;
	string left  = divideConquer(first, mid, arr);
	string right = divideConquer(mid + 1, last, arr);
	string temp = "";
	for(int i = 0; i<left.size() && i<right.size(); i++){
		if(left[i] != right[i]) break;
		temp+= left[i];
	}
	temp+='\0';
	return temp;
}
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	while(cin >> n){
		string arr[n];
		for(int i = 0; i< n; i++) cin >> arr[i];
		string prefix = divideConquer(0,n-1, arr);
		cout << prefix << endl;
	}
	
	return 0;
}
