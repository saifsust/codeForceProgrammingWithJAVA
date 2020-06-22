#include<bits/stdc++.h>
using namespace std;
#define eqn(n) (((n)*(n-1)*(n-2))/6)
int result = 1e8;

bool isValid(int mid, string str){
	int check[4]={0};
	for(int  i = 0; i<mid; i++) check[str[i]-'0']++;
	
	for(unsigned int i = mid; i<str.size(); i++){
		check[str[i] - '0']++;
		if(check[1]>0 && check[2] > 0 && check[3] > 0) return true;
		check[str[i - mid]-'0']--;	
	}
	
	return false;
	
}

void binarySearch(int first, int last, string str){
	if(first >(int)str.size() || last < 0  || first > last) return;
	int mid = (int)(first + last)/2;
	if(isValid(mid-1, str)){
		result = min(result, mid);
	 return binarySearch(first, mid - 1, str);
	}else return binarySearch(mid +1, last, str);
}

void solve(){
	
	string str;
	cin >> str;
	result = 1e8;
	binarySearch(3, str.size(), str);
	printf("%d\n", result== 1e8 ?0 : result);
	
}

int main(){	
	int t;
	scanf("%d", &t);
	while(t--){
	  solve();	
	}
	return 0;
}
