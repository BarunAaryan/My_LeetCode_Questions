class Solution(object):
    def sumByD(self, nums, div):
        sum=0
        for num in nums:
            sum += (num + div - 1)// div
        return sum
    def smallestDivisor(self, nums, threshold):
        """
        :type nums: List[int]
        :type threshold: int
        :rtype: int
        """
        if len(nums) > threshold: 
            return -1
        low=1
        high = max(nums)
        #BS on answer
        while(low< high):
            mid = low + (high-low)//2
            if self.sumByD( nums, mid)<=threshold :
                high = mid
            else:
                low = mid+1
        return low