 int longestKSubstr(string s, int k) {
        
        int ans = -1;
        
        if(!k) return ans; 
        
        
        for(int i = 0; i< s.size(); i++){
            int arr[26], ck= k;
            memset(arr, 0 , sizeof(arr));
            
            for(int j = i; j<=s.size(); j++){
                
                if((j == s.size() || arr[s[j] - 'a'] == 0) && ck == 0){
                    ans = max(ans, j - i);
                    break;
                }
                
                if(arr[s[j] - 'a'] == 0 ) --ck;
                
                ++arr[s[j] - 'a'];
                
            }
        }
        
        return ans;
    }
