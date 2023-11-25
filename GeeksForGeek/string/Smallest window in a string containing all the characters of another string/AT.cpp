string smallestWindow (string s, string p)
    {
        const int N = 26;
        const int n = p.size();
        
        vector<int> p_arr(N, 0);
        int need = 0;
        
        for(int i = 0; i< n; i++){
            ++p_arr[p[i] - 'a'];
            if(p_arr[p[i] - 'a'] == 1) ++need;
        }
        
        vector<int> f_arr(N, 0);
        int found = 0;
        
        int start_idx = 0, len = INT_MAX;
        
        int right = 0, left = 0;
        
        while(right < s.size()){
            
            ++f_arr[s[right] - 'a'];
            
            if(f_arr[s[right] - 'a'] == p_arr[s[right] - 'a']) ++found;
            
            while(found == need){
                
                 if(len > right - left + 1){
                     len = right - left + 1;
                     start_idx = left;
                 }
                 
                --f_arr[s[left] - 'a'];
                
                if(f_arr[s[left] - 'a'] < p_arr[s[left] - 'a']) --found;
                
                ++left;
            }
            
            
            
            ++right;
        }
        
        if(len == INT_MAX) return "-1";
        
        
        return s.substr(start_idx, len);
        
    }
