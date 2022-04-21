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
    const int N = 1003;
    int T, n;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> n;
        vector<string> strs;
        string str;
        map<string , long long> counter;
        for (int  i = 0; i < n; i++) {
            cin >> str;
            if (counter[str] != 0) {
                counter[str]++;
                continue;
            }
            counter[str]++;
            strs.push_back(str);
        }
        long long ans = 0;
        for (int i = 0; i < strs.size() - 1; i++) {
            for (int j = i + 1; j < strs.size(); j++) {

                if (strs[i][0] == strs[j][0] && strs[i][1] == strs[j][1]) {
                    continue;
                }

                if ( strs[i][0] == strs[j][0] ||  strs[i][1] == strs[j][1]) {
                    ans += counter[strs[i]] * counter[strs[j]];
                }

            }
        }

        cout << ans << endl;

    }

    return 0;
}
