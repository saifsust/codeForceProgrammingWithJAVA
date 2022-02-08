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
    string str;
    int counter[26];
    int n;
    cin >> n >> str;
    memset(counter, 0, sizeof(counter));
    for (int i = 0; i < str.size(); i++) {
        ++counter[str[i] - 'A'];
    }

    int Anton = counter[0];
    int Danik = counter['D' - 'A'];

    if (Anton == Danik) {
        cout << "Friendship" << endl;
    } else {
        cout << (Anton > Danik ? "Anton" : "Danik") << endl;
    }

    return 0;
}
