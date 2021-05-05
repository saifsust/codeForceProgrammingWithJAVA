#include<bits/stdc++.h>
using namespace std;

// longest common Prefix


int main() {

	const int N = 100;
	string arr[N];
	int n;
	while(cin >> n) {
		for(int i = 0; i<n; i++) cin >> arr[i];
		string prefix= arr[0];
		for(int count = 1; count < n; count++) {
		//	cout << prefix << endl;
			string temp = "";
			for(int i = 0; i<prefix.size() && i<arr[count].size(); i++) {
				if(prefix[i] != arr[count][i]) break;
				temp += prefix[i];
			}
			temp+='\0';
			prefix= temp;
		}
		cout << prefix << endl;
	}
	return 0;
}
