 vector<int> factorial(int N){
       
       vector<int> ans;
       
       ans.push_back(1);
       
       if(N == 0 || N == 1) return ans;
       
       for(int i = 2; i <=N; i++){
           ans  = mult(ans, digits(i));
       }
       
       reverse(ans.begin(), ans.end());
       
       return ans;
       
    }
    
    vector<int> digits(int n){
        vector<int> b;

        while(n){
            b.push_back(n % 10);
            n /= 10;
        }
        
        return b;
    }
    
    vector<int> mult(vector<int> a, vector<int> b){
        
        vector<int> ans;
        
        for(int i = 0; i < b.size(); i++){
            
            vector<int> ans2;
            int carry = 0;
            
            for(int j = 0; j<a.size(); j++){
                int num = carry + b[i] * a[j];
                carry = num / 10;
                ans2.push_back(num % 10);
                
            }
            
            if(carry) ans2.push_back(carry);
            
            ans = add(ans, ans2, i);
        }
        
        return ans;
    }
    
    vector<int> add(vector<int> &a, vector<int> b, int idx){
        if(a.empty()) return b;
        
         int carry = 0;
         int j = 0;
         int i = idx;
         
         for(; i<a.size() && j < b.size(); i++, j++){
             int num = a[i] + b[j] + carry;
             carry = num / 10;
             a[i] = num % 10;
         }
         
         if(i == a.size()){
             while(j < b.size()){
             int num = carry + b[j];
             carry = num / 10;
             a.push_back(num % 10);
             j++;
             }
         }else
         
         if( j == b.size()){
            while(i < a.size()){
             int num = carry + a[i];
             carry = num / 10;
             a[i] = num % 10;
             i++;
             }
             
         }
         
         if(carry){
             a.push_back(carry);
         }
        
         return a;
    }
