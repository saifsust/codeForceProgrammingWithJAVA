int LPS(string str, int start, int end, vector<vector<int>> &memory){
    if(start > end) return 0;
    
    if(start == end) return memory[start][end] = 1;
    
    if(memory[start][end] != -1) return memory[start][end];
    
    if(str[start] == str[end]) return memory[start][end] =  2 + LPS(str, start + 1, end - 1, memory);
    
    int left = LPS(str, start , end - 1, memory);
    int right = LPS(str, start + 1, end , memory);
    
    return memory[start][end] = max(left, right);
}

int MinRemove(int n, string s){
    vector<vector<int>> memory(n, vector<int>(n , -1));
    int len = LPS(s, 0, n - 1, memory);
    
    if(len == n) return 1;
    
    
    vector<int> ans;
    
    for(int i  = n - 1; i>=0; i--){
        for(int j = n - 1; j>= i; j--){
           
       //    cout << memory[i][j] << " ";
           if(memory[i][j] != -1)
            ans.push_back(memory[i][j]);
        }
        
       // cout << endl;
    }
    
    
    sort(ans.begin(), ans.end(), [&](const int a, int b){
       return a > b; 
    });
    
    len = 0;
    int sum = 0, i = 0;
    while( sum < n && i < n){
        //cout << ans[i] << endl;
        sum += ans[i++];
        ++len;
    }
    
    return len;
}
