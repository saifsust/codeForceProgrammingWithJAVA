class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int column = matrix[0].length;
        int row = matrix.length;
        
        for(int r = 0; r< row; r++){
                int[] isRowExist = new int[column + 5];
                int[] isColumnExist = new int[column + 5];
            for(int c = 0; c< column; c++){
                if( matrix[r][c] < 1 || matrix[r][c] > column || isRowExist[matrix[r][c]] == 1 || isColumnExist[matrix[c][r]] == 1) return false;
                else {
                    isRowExist[matrix[r][c]] = 1;
                    isColumnExist[matrix[c][r]] = 1;
                }
            }

            
        }
        
        return true;
        
    }
}
