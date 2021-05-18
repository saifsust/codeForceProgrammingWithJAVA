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
        cin >>n;
        vector<int>arr(n);
        map<int, int>counter;
        int mx = 0;
        for(int i = 0; i<n; i++){
            cin >> arr[i];
            counter[arr[i]]++;
        }
        map<int, int> marker;
        for(auto it=counter.begin(); it != counter.end(); it++){
            marker[it->second]++;
        }
        int left = 0 , right = n, remainRight = int(counter.size());
        int ans = n;
        for(auto it = marker.begin() ; it != marker.end(); it++){
            //cout <<"( " << it->first << " " << it->second << ") ";
            ans = min(ans, left + right - remainRight * it->first);
            left += it->first * it->second;
            right -= it->first * it->second;
            remainRight -= it->second;
        }
        //cout << endl;
        cout << ans << endl;

       
    }
    return 0;
}
