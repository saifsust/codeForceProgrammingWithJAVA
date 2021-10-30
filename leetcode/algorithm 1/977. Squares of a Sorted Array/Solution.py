class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        start = 0
        end = len(nums) -1
        result = []
        while start <= end:
            print(start)
            if abs(nums[start]) > abs(nums[end]):
                result = [nums[start]**2] + result
                start += 1
            else:
                result = [nums[end]**2] + result
                end -= 1
        
        return result
        
