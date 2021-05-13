class Solution {
public:
    int longestValidParentheses(string s) {
        if(s == "") return 0;
        stack<int> ss;
        int counter = 0;
        int maxLen = 0;
        ss.push(-1);
        int len = 0;
        for(int i = 0; i< s.size(); i++){
            if(s[i] == '(' ){
                ss.push(i);
            }
            if(s[i] == ')'){
                 ss.pop();
                 if(ss.empty()) ss.push(i);
                else maxLen = max(maxLen , i - ss.top());
            }
        }
        return maxLen;
    }
};
