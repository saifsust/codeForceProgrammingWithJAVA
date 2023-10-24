int longestKSubstr(string s, int k) {
     // Naive solution O(n ^ 2)
     
     
     int ans  = -1;
     if(k == 0) return ans;
     
     for(int i = 0; i < s.size(); i++){
          
          int ck = k;
          int arr[27];
          
          memset(arr, 0, sizeof(arr));
          
          
          for(int j = i; j<=s.size(); j++){
              
              if(j == s.size()){
                  if(ck == 0) ans = max(ans, j - i);
                  break;
              }
              
              int idx = s[j] - 'a';
              
              
              if(arr[idx] == 0 && ck == 0){
                  ans = max(ans, j - i);
                  break;
              }
              
              if(arr[idx] == 0) --ck;
              
              
              ++arr[idx];
              
          }
          
          
          
          
     }
     
     
     return ans;
     
    }
