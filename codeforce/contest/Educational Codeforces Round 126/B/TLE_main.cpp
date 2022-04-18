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
        queue<int>q;
        q.push(num);
        int depth[mod + 5];

        for (int i = 0; i <= mod; i++) {
            depth[i] = INT_MAX;
        }

        depth[num] = 0;

        while (!q.empty()) {
            int front = q.front();
            q.pop();

            int child1 = (front + 1) % mod;
            int child2 = (front * 2) % mod;


            if (depth[child1] > depth[front] + 1) {
                depth[child1] = depth[front] + 1;
                if (child1 != 0)
                    q.push(child1);
            }

            if (depth[child2] > depth[front] + 1) {
                depth[child2] = depth[front] + 1;
                if (child2 != 0)
                    q.push(child2);
            }

        }

        cout << depth[0] << " ";

    }
    return 0;
}
