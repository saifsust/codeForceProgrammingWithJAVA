
//User function template for C++

class Solution{
  public:		
	int lps(string s) {
	    const int n = s.size();
	    vector<int> z(n, 0);
	    
	    int left = 0, right = 0;
	    
	    int ans = 0;
	    
	    for(int i = 1; i<n; i++){
	        if(i < right){
	            z[i] = min(right - i, z[i  - left]);
	        }
	        
	        while(i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
	        
	        if( i + z[i] > right){
	            left = i;
	            right = i + z[i];
	        }
	        if(i + z[i] == n) ans = max(ans, z[i]);
	    }
	    
	    
	    return ans;
	}
};
