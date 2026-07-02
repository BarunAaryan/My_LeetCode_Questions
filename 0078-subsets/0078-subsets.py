class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        n = len(nums)
        total_subsets = 1 << n  # 2^n
        
        for mask in range(total_subsets):
            subset = []
            for i in range(n):
                if (mask & (1 << i)) != 0:
                    subset.append(nums[i])
            ans.append(subset)
            
        return ans