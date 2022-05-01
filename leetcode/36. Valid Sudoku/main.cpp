class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int checker[11], row[11], col[11];
      
        for(int s = 0; s<9; s++){
            memset(row, 0, sizeof(row));
            memset(col, 0, sizeof(col));
            for(int idx = 0; idx<9; idx++){
                if(isdigit(board[idx][s]) && ++row[board[idx][s] - '0'] == 2) return false;
                if(isdigit(board[s][idx]) && ++col[board[s][idx] - '0'] == 2) return false;
            }
        }
       
        
        for(int sr = 0; sr<9; sr+=3){
            for(int sc = 0; sc<9; sc+=3){
                memset(checker, 0, sizeof(checker));
                for(int i = sr; i<sr + 3; i++){
                    for(int j = sc ; j<sc+3; j++){
                        if(!isdigit(board[i][j])) continue;
                        if(++checker[board[i][j] - '0'] ==2) return false;
                    }
                }  
            }
        }
        
        return true;
    }
};
