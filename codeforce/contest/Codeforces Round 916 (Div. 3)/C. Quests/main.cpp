#include<bits/stdc++.h>
using namespace std;

int main(){
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        const int R = 200000;
        const int L = 1;
        int T;
        cin >> T;
        for(int t = 1; t <= T; t++){
                int n, q;

                cin >> n >> q;
                assert(L<= n && n <=R);
                assert(L<= q && q <= R);
                vector<int> a(n), b(n);

                for(int i  = 0; i<n; i++){
                        cin >> a[i];
                }

                for(int i = 0; i<n; i++){
                        cin >> b[i];
                }

                int mx = 0, suma= 0, result = 0;

                for(int i = 1; i<=n && i<=q; i++){
                        mx = max(mx, b[i - 1]);
                        suma += a[i - 1];
                        result = max(result, suma + (q - i) * mx);
                }

                cout << result << endl;


        }
        return 0;
}
