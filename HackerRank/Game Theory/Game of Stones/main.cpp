#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'gameOfStones' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER n as parameter.
 */

const int N = 105;
int  position[N];
int isFirstWin(int n){
    if(n == 1) return position[n] = 0;
    if( n == 2 || n == 3 || n == 5) return position[n] = 1;
    if(position[n] != -1) return position[n];
    if(!isFirstWin(n - 2)) return position[n] = 1;
    if(!isFirstWin(n - 3)) return position[n] = 1;
    if(!isFirstWin(n - 5)) return position[n] = 1;
    return position[n] = 0;
}


string gameOfStones(int n) {
    memset(position, -1 , sizeof(position));
    if(isFirstWin(n)) return "First";
    return "Second";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string n_temp;
        getline(cin, n_temp);

        int n = stoi(ltrim(rtrim(n_temp)));

        string result = gameOfStones(n);

        fout << result << "\n";
    }

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
