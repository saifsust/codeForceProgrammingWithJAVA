#include<bits/stdc++.h>
using namespace std;
 
 
int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string num;
    cin >> num;
    int isMiss[10];
    memset(isMiss, 0, sizeof(isMiss));
    for (int i = 0; i < num.size(); i++) {
        isMiss[num[i] - '0']++;
    }
    for (int i = 0; i < 10; i++) {
        if (isMiss[i] == 0) {
            cout << i << endl;
            break;
        }
    }
    return 0;
}
