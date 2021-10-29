class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        int first = -1, last = -1;
        
        if(nums.length == 0) return new int[]{first, last};
        if(nums.length == 1 && nums[0] == target) return new int[]{0,0}; 
        
        // lowest value search
        
        while(start <= end){
            int mid = (start + end) >> 1;
           // System.out.println(mid);
            if(first == -1 && nums[mid] == target) first = mid;
    
            if( (mid - 1 >=0 && nums[mid - 1] < target) &&  nums[mid] == target) {
                first = mid;
                break;
            }
            if(mid +1 < nums.length && nums[mid] < target && nums[mid + 1] == target){
                first = mid + 1;
                break;
            }
            
            if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
            
        }
        
       if( end < 0 && nums[0] == target) first = 0;
        
        // highest value search
        
        start = 0;
        end = nums.length - 1;
        
        while(start <= end){
            int mid = (start + end ) >> 1;
           // System.out.println(mid);
            
             // mid == target
            //  mid  + 1 === target
            // mid + 1 > target
            // mid + 1 == length
            if(last == -1 && nums[mid] == target) last = mid;
            
            if(nums[mid] == target && mid + 1 < nums.length && (nums[mid + 1] > target || mid + 1 == nums.length -1)){
                last = mid ;
                if(nums[mid + 1] == target) ++last;
                break;
            }
           
            if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        
        if(start == nums.length -1 && nums[start] == target) last = start;
        
        return new int[]{first, last};
    }
}
