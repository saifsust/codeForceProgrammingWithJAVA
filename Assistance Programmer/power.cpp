#include<bits/stdc++.h>
using namespace std;

long long power(long num, long pow){
	if(pow == 0) return 1;
	if(pow == 1) return num;
	if(pow %2 == 0) return power(num*num,pow/2);
	else return num * power(num, pow -1);
}

long long linerPower(int num, int pow){
	long long ans = 1;
	for(int i = 1; i<= pow; i++){
		ans *= num;
	}
	return ans;
}

int main(){
	
	
	int num, pow;
	while(cin >> num >> pow){
	   cout << "effective   ans: " << power(num, pow) << endl;
	   cout << "normal loop ans: " << linerPower(num, pow) << endl;
	}
	
	
	return 0;
}
