 int findSubString(string str)
    {
        
        const int N = 256;
        
        int counter[N];
        memset(counter, 0, sizeof(counter));
        
        int uniqueChars = 0;
        
        for(int i = 0; i< str.size(); i++){
            if(counter[str[i]]  == 0){
                ++uniqueChars;
            }
            ++counter[str[i]];
        }
        
        memset(counter, 0, sizeof(counter));
        
        int left = 0, right = 0;
        
        int ans = INT_MAX;
        
        while(right < str.size()){
                
           ++counter[str[right]];
           
           while(counting(counter) == uniqueChars && left <= right){
               
               if(ans > right - left + 1){
                   ans = right -  left + 1;
               }
               --counter[str[left]];
               ++left;
           }
             
           ++right;
        }
        
        
        return ans;
        
    }
    
    int counting(int counter[]){
        
        int count = 0;
      
        for(int i = 0; i<256; i++){
            if(counter[i] >= 1) ++count;
        }
        
        return count;
    }
