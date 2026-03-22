class Solution(object):
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n= len(nums)
        #Edge Case: Only one element in the array
        if n==1:
            return nums[0]
        #Edge Case: First element is the unique number 
        if nums[0]!=nums[1]:
            return nums[0]
        #Edge Case: Last Element is the unique number
        if nums[n-1]!=nums[n-2]:
            return nums[n-1]
        low, high = 1, n-2
        #Perform Binary Search 
        while(low<=high):
            mid = (low+high)//2
            #check if middle element is the unique one 
            if nums[mid]!=nums[mid+1] and  nums[mid]!=nums[mid-1]:
                return nums[mid]
            #if mid is in the left half pairing is valid
            if (mid %2 ==1 and nums[mid]==nums[mid-1]) or \
               (mid%2==0 and nums[mid]==nums[mid+1]):
               #Move to the right half 
               low = mid+1
            else:
                #Move to the lefr half 
                high = mid -1
        # Dummy return (not reachable if input is valid)
        return -1
        