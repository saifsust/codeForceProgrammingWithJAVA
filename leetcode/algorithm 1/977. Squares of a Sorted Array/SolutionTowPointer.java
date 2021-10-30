class Solution {
    public int[] sortedSquares(int[] nums) {
    
        int start  = 0, end = nums.length - 1;
        int sortedNums[] = new int[nums.length];
        int index = nums.length - 1;
        
        while(start <= end){
            int first = nums[start] * nums[start];
            int last = nums[end] * nums[end];
            if(first > last){
                sortedNums[index--] =first;
                ++start;
            }else{
                sortedNums[index--] = last;
                --end;
            }
        }
        
        return sortedNums;
    }
}
