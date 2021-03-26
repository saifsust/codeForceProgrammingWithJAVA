#include<bits/stdc++.h>
using namespace std;

int main(int argc, char* argv[]){
  // bubble sort

  int n;
  while(cin >> n){

   int arr[n];

   for(int i =0; i<n; i++) cin >> arr[i];

   for(int i = 0; i<n-1; i++){
        for(int j = i + 1; j<n; j++){
           if(arr[i] > arr[j]) swap(arr[i], arr[j]);
        }
   }

   for(int i = 0; i< n; i++) cout << arr[i] << " ";
    cout << endl;

  }

 return 0;
}
