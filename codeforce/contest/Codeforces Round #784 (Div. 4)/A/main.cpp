#include<bits/stdc++.h>
using namespace std;
const int mod = 32768;
 
 
int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T, rating;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> rating;
 
 
        if (rating <= 1399) {
            cout << "Division 4" << endl;
            continue;
        }
 
        if (1400 <= rating && rating <= 1599) {
            cout << "Division 3" << endl;
            continue;
        }
 
 
        if (1600 <= rating && rating <= 1899) {
            cout << "Division 2" << endl;
            continue;
        }
 
        if (1900 <= rating) {
            cout << "Division 1" << endl;
            continue;
        }
 
    }
 
    return 0;
}
