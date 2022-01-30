class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while(search(0, original ,nums.length -1, nums) != -1){
            original *= 2;
        }
        return original;
    }
    
    private int search(int first, int key ,int last, int[] nums){
          if( first > last || last < 0) return -1;
          int mid = (first + last) >> 1;
          if(nums[mid] == key) return mid;
           
         if(nums[mid] > key){
             return search(first, key, mid - 1, nums);
         } 
         else {
             return search(mid + 1, key, last, nums);
         }
    }
}
