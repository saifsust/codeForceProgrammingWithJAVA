class Solution {
    public int[] sortedSquares(int[] nums) {
        nums = Arrays.stream(nums).map(x -> x * x).toArray();
        Arrays.sort(nums);
        return nums;
        
    }
}
