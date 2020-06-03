#include<bits/stdc++.h>
using namespace std;

#define MAX 200000
int s[MAX+1];
int ranks[MAX+1];

int just_greater=0;

void build_rank(int n){
	
	ranks[0] = 1;
	for(int i = 1; i<=n; i++){
	 if(s[i] == s[i-1]) ranks[i] = ranks[i-1];
	 else ranks[i] = ranks[i-1]+1;
	}

}


int binarySearch(int first, int value, int last){
	
	if(last < 0) return -1;
	if (first > last) return -1;
	
	int mid = (first + last)/ 2;
	if (value == s[mid]) return mid;
	if(value > s[mid]){
		just_greater = mid;
		return binarySearch(first, value, mid -1);
	}
	else return binarySearch(mid + 1, value, last);


}


int main(){
	
	int n;
	scanf("%d", &n);
	for(int i = 0; i<n; i++) scanf("%d", &s[i]);
	build_rank(n);
	
	//for(int i = 0; i<=n; i++) cout<< rank[i] << "  ";
	//cout<<endl;
	
	int m, point;
	scanf("%d", &m);
	//int a[m+1];
	
	//for(int i = 0; i<m; i++) scanf("%d", &a[i]);
	
	for(int i = 0; i<m; i++){
	int alice;
	scanf("%d", &alice);
	int current_rank = 1;	
	
	just_greater = n;
	point = binarySearch(0, alice, n-1);
	//while( point>=0 && alice > s[point]) point--;
	//cout<< point << "  " << just_greater<< endl;	
	if(point == -1 ) current_rank= ranks[just_greater];
	else current_rank = ranks[point]; 
	printf("%d\n", current_rank);
	}

	return 0;
}
