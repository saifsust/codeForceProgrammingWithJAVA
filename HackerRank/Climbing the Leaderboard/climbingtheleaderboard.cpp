#include<bits/stdc++.h>

using namespace std;

#define ALL(t) t.begin(),t.end()
typedef vector<int>vi;
struct comp{
	
 template<typename t> bool operator()(const t &a, const t &b) const{
   return a>b;
 }
};
int just_greater = 1;
int binarySearch( int first, int value,  int last, vi board){
	if(last < 0) return -1;
	if(first > last) return -1;
	
	unsigned int mid = (unsigned int)(first + last)/2;
	
	if(board[mid] == value) return mid +1;
	
	if(board[mid] > value){
		just_greater = (int)mid+2;
		return binarySearch(mid + 1, value, last, board);
	}else{
		return binarySearch(first, value, mid -	1, board);
	}
}

int main(){
	
	unsigned int n, m;
	scanf("%d", &n);
	vi board;
	int value;
	
	map<long, bool>exist;
	
	for(unsigned int i = 0; i<n; i++){
		scanf("%d", &value);
		if(exist[value]) continue;
		exist[value] = true;
		board.push_back(value);
	}
	sort(ALL(board), comp());
	for(unsigned int i = 0; i<board.size(); i++) printf("%d ",  board[i]);
	printf("\n");
	scanf("%d", &m);
	int arr[m];
	for(unsigned int i = 0; i<m; i++) scanf("%d", &arr[i]);
	
	for(unsigned int i = 0; i<m; i++){
		int alice = arr[i];
		//scanf("%d", &alice);
		//clock_t start = clock();
		just_greater = 1;
		int rank = binarySearch(0, alice, board.size()-1,board);
		printf("%d\n", rank == -1 ? just_greater: rank);
		//clock_t end = clock();
		//double duration = (double) (end - start)/ CLOCKS_PER_SEC;
		//printf("%lf\n", duration);
	}
	
	return 0;
}
