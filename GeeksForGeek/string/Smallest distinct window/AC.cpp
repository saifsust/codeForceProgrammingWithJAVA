    int findSubString(string str)
    {
        int ans = INT_MAX;
        const int CHR_N = 256;
        
        int arr[CHR_N];
        
        memset(arr, 0, sizeof(arr));
        
        int unique = 0;
        const int N = str.size();
        
        for(int i = 0;  i< N; i++){
            if(arr[str[i]] == 0) ++unique;
            ++arr[str[i]];
        }
        
        memset(arr, 0, sizeof(arr));
        
        int head = 0, matches = 0;
        
        for(int tail = 0 ; tail < N; tail++){
            if(arr[str[tail]] == 0) ++matches;
            ++arr[str[tail]];
            
            while(matches == unique && head <= tail){
                ans = min(ans, tail - head + 1);
                --arr[str[head]];
                if(arr[str[head]] == 0) --matches;
                ++head;
            }
            
        }
        
        return ans;
        
    }
    
