    map<char,int> roman = {{'I', 1}, 
                                      {'V', 5}, 
                                      {'X', 10},
                                      {'L', 50},
                                      {'C', 100},
                                      {'D', 500},
                                      {'M', 1000}};
  public:
    int romanToDecimal(string &str) {
        
        int num = 0;
        
        
        for(int i = 0; i < str.size(); i++){
            if( i + 1 < str.size() && roman[str[i]] < roman[str[i + 1]]){
                num += roman[str[i + 1]] - roman[str[i]];
                i++;
            }else{
                num += roman[str[i]];
            }
        }
        
        return num;
    }
