string longestPalin (string S) {
        const int n= S.size();
        
        int mx = 0, start;
        
        for(int i = 0; i<n; i++){
            int left = i, right  = i;
            
            while(left >= 0 && right < n){
                if(S[left] != S[right]) break;
                
                --left, ++right;
            }
            
             
            if(mx < right - left  - 1){
                    mx = right  - left - 1;
                    start = left + 1;
            }
        }
        
        for(int i = 0; i<n; i++){
            int left = i, right = i + 1;
            while(left >= 0 && right < n){
                if(S[left] != S[right]) break;
                --left, ++right;
            }
            
            if(mx < right - left - 1){
                mx = right - left - 1;
                start = left + 1;
            }
        }
        
        
        
        
       
        
        return S.substr(start,  mx);
        
    }
