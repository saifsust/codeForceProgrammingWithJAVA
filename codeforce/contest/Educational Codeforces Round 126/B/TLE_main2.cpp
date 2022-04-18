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
    int T, num;
    cin >> T;
    for (int  t  = 1; t <= T; t++) {
        cin >> num;
        num %= mod;
        queue<pair<int, int>>q;
        q.push({num, 0});
        int ans = INT_MAX;
        bool visited[mod];
        memset(visited, false, sizeof(visited));
        visited[num] = true;
        while (!q.empty()) {
            pair<int, int> front = q.front();
            q.pop();

            int child1 = (front.first + 1) % mod;
            int child2 = (front.first * 2) % mod;

            if (child1 == 0) {
                ans = min(ans, front.second + 1);
            }

            if (child2 == 0) {
                ans = min(ans, front.second + 1);
            }

            if (!visited[child1]) {
                visited[child1] = true;
                q.push({child1, front.second + 1});
            }

            if (!visited[child2]) {
                visited[child2] = true;
                q.push({child2, front.second + 1});
            }

        }

        cout << ans << " ";

    }
    return 0;
}
