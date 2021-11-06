class Solution {
    
    private final int SIZE = 230;
    public int lengthOfLongestSubstring(String s) {  
        int mx = 0;
        
        for(int i = 0; i<s.length(); i++){
            for(int  j = i; j<s.length(); j++){
                if(isUnique(s, i, j)){
                    int len = j - i + 1;
                    if(len > mx) mx = len;
                }else break;
            }
        }
      
        return mx;
    }
    
    private boolean isUnique(String s, int first, int last){
        boolean[] unique = new boolean[SIZE];
        for(int i = 0; i<SIZE; i++) unique[i]=false;
        for(int i = first; i<=last; i++){
            if(unique[(int)s.charAt(i)]) return false;
            unique[(int)s.charAt(i)] = true;
        }
        return true;
            
    }
}
