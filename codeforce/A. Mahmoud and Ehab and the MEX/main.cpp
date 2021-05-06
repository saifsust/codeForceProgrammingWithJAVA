#include<bits/stdc++.h>
using namespace std;
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, x;
	cin >> n >> x;
	int arr[n];
	int mex[1000];
	memset(mex, 0 , sizeof(mex));
	for(int i = 0; i<n ; i++){
	  cin >> arr[i];
	  mex[arr[i]]=1;	
	}
	int counter = 0;
	for(int i = 0; i<x; i++){
		if(mex[i] == 0) ++counter;
	} 
	if(mex[x] == 1) ++counter;
	cout << counter << endl;
	return 0;
}
