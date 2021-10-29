class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int result = -1;
        // return number of rows matrix.length
        // return number of column matrix[0].length
        if(matrix.length == 0) return false;
        for(int row = 0; row < matrix.length; row ++){
           result = binarySearch(matrix[row], 0, matrix[0].length -1, target);
           if(result > -1) return true;
        }
        return false;
        
    }
    
    private int binarySearch(int nums[], int start, int end, int target){
         while(start <= end){
             int mid = (start + end) >> 1;
             if(nums[mid] == target) return mid;
             else if(nums[mid] < target) start = mid + 1;
             else end = mid - 1;
         }
        return -1;
    }
}
