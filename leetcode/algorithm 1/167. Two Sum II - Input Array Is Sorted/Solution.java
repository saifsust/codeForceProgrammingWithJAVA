class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = -1, last = -1;
        for(int i = 0; i< numbers.length - 1; i++){
            int search = target - numbers[i];
            int in = Arrays.binarySearch(numbers, i + 1, numbers.length, search);
            if(in >= 0) return new int[]{i + 1, in + 1};
        }
        return new int[]{-1, -1};
    }
}
