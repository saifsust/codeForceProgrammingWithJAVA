#include<bits/stdc++.h>
using namespace std;
// Two pointer algorithm to sort two array in efficient time.

void sortTwoArray(long long *arr1, long long *arr2,int size1, int size2){
    // arr1.length > arr2.length and arr1.length == size1 + size2
   // two arrays are sorted
   int i=size1-1, j= size2 -1, k = size1 + size2-1;
   while(i >= 0 && j >= 0){
       if(arr1[i] > arr2[j]) arr1[k--] = arr1[i--];
       else arr1[k--] = arr2[j--];
   }
   while(k>=0 && i>= 0) arr1[k--] = arr1[i--];
   while(k >= 0 && j>=0) arr1[k--] = arr2[j--];
}
int main(int argc, char* argv[]){
    ios::sync_with_stdio(true);
    cin.tie(NULL);
    int size1, size2;
    while(cin >> size1 >>  size2){
     long long arr1[size1 + size2], arr2[size2];
     for(int i = 0; i< size1 ; i++)  cin >> arr1[i];
     for(int j = 0; j< size2; j++) cin >> arr2[j];
     sortTwoArray(arr1, arr2, size1, size2);
     for(int i = 0; i< size1 + size2; i++) cout << arr1[i] << " ";
     cout << endl;
    }
    return 0;
}