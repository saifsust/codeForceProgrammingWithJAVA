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
    long long a, b, k;
    cin >> a >> b >> k;
    long long counter = 0;
    while (a < b && a != b) {
        a *= k;
        ++counter;
    }
 
    cout << counter << endl;
    return 0;
}
