class Solution {
    public int search(int[] nums, int target) {
           int first = 0, last = nums.length - 1;
           while(first + 1 <= last && nums[first] < nums[first + 1]) ++first;
           //stem.out.println(first);
           int index = binarySearch(nums,0, first, target);
           if(index > -1) return index;
          return binarySearch(nums, first + 1, last, target);
        
    }
    
    private int binarySearch(int nums[],int start, int end, int target){ 
        while(start <= end){
            int mid = (start + end) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
