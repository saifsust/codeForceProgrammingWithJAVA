#include<bits/stdc++.h>
using namespace std;
long long inversion = 0;

void divide(int,int, int*);
void conquer(int,int , int , int*);

void divide(int s, int l, int *nums){
	if(s > l || s==l) return;
	//cerr << "done " << endl;
	int mid = (s + l) >> 1;
	divide(s, mid, nums);
	divide(mid + 1, l, nums);
    conquer(s, mid, l, nums);	
}
void conquer(int s, int mid, int l, int *nums){
	int arr[s+l+2];
	int i = s, k = mid+1, p=s;
	while(i <= mid && k <= l){
		if(nums[i] > nums[k]){
			arr[p++] = nums[k++];
		inversion += mid - i + 1;
		}else arr[p++] = nums[i++];
	}
	while(i<= mid) arr[p++] = nums[i++];
	while(k<= l) arr[p++] = nums[k++];
	for(int i = s; i<=l; i++) nums[i] = arr[i];
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test;
	assert(cin >> test);
	for(int tt = 1; tt<= test; tt++){
		int n;
		assert(cin >> n);
		int nums[n];
		for(int i = 0; i<n; i++) assert(cin >> nums[i]);
		inversion = 0;
		divide(0, n-1, nums);
		
		cout << inversion << endl;
	}
	return 0;
}
