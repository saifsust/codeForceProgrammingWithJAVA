int strstr(string s, string x)
{
    // O(n ^ 2) complexity
   for(int i = 0; i < s.size(); i++){
       if(s[i] == x[0]){
           int k = i, j = 0;
           while(k < s.size() && j < x.size() && s[k] == x[j]) k++, j++;
           if(j == x.size()) return i;
       }
   }
   
   return -1;
}
