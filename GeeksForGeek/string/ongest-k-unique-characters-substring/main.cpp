 int longestKSubstr(string s, int k) {
        
        int ans = -1;
        
        if(!k) return ans; 
        
        const int NN = 26;
        
        int arr[NN];
        
        memset(arr, 0, sizeof(arr));
        
        int  left = 0, right = 0;
    
        int ck = 0;
        
        for(;right < s.size(); right++){
            
            if(arr[s[right] - 'a'] == 0) ++ck;
            
            if(ck > k){
                ans = max(ans , right - left);
                
                while(left < right && ck  > k ){
                    --arr[s[left] - 'a'];
                    if(arr[s[left] - 'a'] == 0) --ck;
                    left++;
                }
            }
            ++arr[s[right] - 'a'];
        }
        
        
        if(ck == k){
            ans = max(ans, right - left );
        }
        
        
        return ans;
    }
