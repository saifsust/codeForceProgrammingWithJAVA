#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'powerSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER X
 *  2. INTEGER N
 */
map<long long,map<long long, long long>>powNp;
map<long long , map<long long, long long>>powS;
long long pow(int n, int p){
   // cout << n << " " << p << endl;
    if(n == 0) return 0;
    if(p == 0) return powNp[n][p] = 1;
    if(powNp[n][p] != 0) return powNp[n][p];
    if(p %  2 == 0) return powNp[n][p]=pow(n *n, p/2);
    return powNp[n][p] = n * pow(n, p - 1);
}

int powSum(int sum, int p, int start){
    if(sum == 0) return 1;
    if(sum < 0) return 0;
    int s = 0;
    for(int num = start; sum - pow(num, p) >=0 ; num++){
        int nn = sum - pow(num, p);
        s+=powSum(nn, p, num + 1);
    }
    return s;
}

int powerSum(int X, int N) {
    
    return powSum(X,N,1);
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string X_temp;
    getline(cin, X_temp);

    int X = stoi(ltrim(rtrim(X_temp)));

    string N_temp;
    getline(cin, N_temp);

    int N = stoi(ltrim(rtrim(N_temp)));

    int result = powerSum(X, N);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
