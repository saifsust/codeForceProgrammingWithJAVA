#include<bits/stdc++.h>
using namespace std;

int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b , a % b);
}

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    //cout.tie(NULL);

    string berland, birland;
    cin >> berland >> birland;

    bool mistaken = false;
    for (int first = 0, last = birland.size() - 1; first < berland.size() && last >= 0; first++, last--) {
        if (berland[first] != birland[last]) {
            mistaken = true;
            break;
        }
    }

    if (mistaken) {
        cout << "NO" << endl;
    } else {
        cout << "YES";
    }

    return 0;
}

