class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0, end = nums.length-1;
        
        while(start <= end){
            int mid = (start + end) >> 1;
            if(nums[mid] == target){
                return mid;
            }else {
                if(mid + 1 < nums.length && nums[mid] < target &&  target < nums[mid + 1]){
                    return mid + 1;
                }else {
                    if(nums[mid] < target){
                        start = mid + 1;
                    }else {
                        end = mid -1;
                    }
                }
            }
        }
        return start;
        
    }
}
