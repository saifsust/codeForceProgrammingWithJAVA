#include<bits/stdc++.h>
using namespace std;

int main(){
    #ifndef ONLINE_JUDGE
     freopen("in.in", "r", stdin);
     freopen("out.in", "w", stdout);
    #endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int arr[n];
        int c[3];
        memset(c,0, sizeof(c));
        for(int i = 0; i<n; i++){
            cin >> arr[i];
            c[arr[i] % 3]++;
        }
        int counter = 0;
        while(c[0] != c[1] || c[1] != c[2]){
            int mx = 0, s= 0;
            for(int i = 0; i<= 2; i++) if(c[i] > mx){
                mx = c[i];
                s = i;
            }

           for(int i = n -1 ; i>=0; i--){
               if(arr[i] % 3 == s){
                   c[arr[i] % 3]--;
                   arr[i]++;
                   c[arr[i] % 3]++;
                   ++counter;
                   break; 
               }
           }
        }
        cout << counter << endl;

    }    
    
    return 0;
}
