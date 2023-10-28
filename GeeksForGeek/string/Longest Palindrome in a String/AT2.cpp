    string longestPalin (string S) {
        const int n= S.size();
        
        int mx = 1, start = 0;

        for(int i = 0; i<n; i++){
            int left = i, right  = i;
            
            while(left >= 0 && right < n && S[left] == S[right]) --left, ++right;
            
            if(mx < right - left - 1){
                mx = right - left - 1;
                start = left + 1;
            }
            
            left = i, right = i + 1;
            
            while(left >= 0 && right < n && S[left] == S[right]) --left, ++right;
            
            if(mx < right - left - 1){
                mx = right - left - 1;
                start = left + 1;
            }
        }
        

    
        
        return S.substr(start,  mx);
        
    }
