#include<bits/stdc++.h>
using namespace std;
const int N = 1000;
const int INF = 10000000;

void heapify(int arr[], int n, int root){
	 int largest = root;
	 int left = root * 2 + 1;
	 int right = root * 2 + 2;
	 if(left < n && arr[left] > arr[largest]) largest = left;
	 if(right < n && arr[right] > arr[largest]) largest = right;
	 if(largest != root){
		 swap(arr[largest], arr[root]);
		 heapify(arr, n, largest);
	 }
	 
}


void maxHeapSort(int arr[], int n){
	// max heap
	for(int i = n/2-1; i>=0; i--){
		heapify(arr, n, i);
	}
	
	for(int i = n - 1; i>0; i--){
		swap(arr[0], arr[i]);
		heapify(arr, i, 0);
	}
	
}

void heapifySort(int arr[], int n, int root){
	int largest = root;
	int left = root * 2 + 1;
	int right = root * 2 + 2;
	if(left < n && arr[left] < arr[largest]) largest = left;
	if(right < n && arr[right] < arr[largest]) largest = right;
	if(largest != root){
		swap(arr[largest], arr[root]);
		heapify(arr, n, largest);
	}
}

void minHeapSort(int arr[], int n){
	for(int i = n/2 - 1; i>= 0; i--){
		heapifySort(arr, n, i);
	}
	
	for(int i = n - 1; i>0; i--){
		swap(arr[0], arr[i]);
		heapifySort(arr, i, 0);
	}
}

int main(){
	int n;
	while(cin >> n){
		int arr[n+1];
		for(int i = 0; i<n; i++) cin >> arr[i];
		maxHeapSort(arr, n);
		for(int i = 0; i<n; i++) cout << arr[i] << " ";
		cout << endl;
		minHeapSort(arr, n);
		for(int i = 0; i< n; i++) cout << arr[i] << " "; 
		cout << endl;
	}
	return 0;
}
