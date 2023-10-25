    vector<int> factorial(int N){
       
       vector<int> ans;
       
       ans.push_back(1);
       
       if(N == 0 || N == 1) return ans;
       
       for(int i = 2; i <=N; i++){
           mult(ans, i);
       }
       
       reverse(ans.begin(), ans.end());
       
       return ans;
       
    }
    
    
    void mult(vector<int> &ans, int x){
        
        int carry = 0;
        
        for(int i = 0; i< ans.size(); i++){
            int num = carry + ans[i] * x;
            carry = num / 10;
            ans[i] = num % 10;
        }
        
        while(carry){
            ans.push_back(carry % 10);
            carry /= 10;
        }
    }
