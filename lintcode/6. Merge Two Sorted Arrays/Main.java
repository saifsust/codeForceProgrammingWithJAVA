public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] nums = new int[A.length+B.length];
        int a=0,b=0,n=0;
        while(a<A.length && b<B.length){
            if(A[a]<B[b])nums[n++]=A[a++];
            else nums[n++]=B[b++];
        }
        if(a>=A.length)while(b<B.length)nums[n++]=B[b++];
        if(b>=B.length) while(a<A.length)nums[n++]=A[a++];
        
        return nums;
    }
}