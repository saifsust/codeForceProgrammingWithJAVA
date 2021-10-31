class Solution {
    public void moveZeroes(int[] nums) {
        //counting sort can not apply
        
      for(int i = 0; i<nums.length; i++){
          int in = searchNoZero(nums, i);
          for(int j = in; j>i; j--) swap(nums, j, j -1);
      }
        
    }
    private int searchNoZero(int[] nums,  int start){
        for(int i = start ; i< nums.length; i++ ) if(nums[i] != 0) return i;
        return -1;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
