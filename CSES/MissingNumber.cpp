#include<bits/stdc++.h>
using namespace std;
int main(){
    //freopen("in.txt", "r", stdin);
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    const int N= (int)2e6;
    int arr[N+1], num;
    for(int i = 0; i<n-1; i++){
        cin >> num;
        arr[num] = 1;
    }
    for(int i  = 1; i<=n; i++){
        if(arr[i]) continue;
        cout << i << " ";
    }
    return 0;
}
