class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low, high = 0, len(nums) - 1

        # Binary search loop
        while low < high:

            # Calculate mid index
            mid = low + (high - low) // 2

            # Check which half to discard
            if nums[mid] > nums[high]:

                # Minimum lies in right half
                low = mid + 1

            else:

                # Minimum lies in left half (including mid)
                high = mid

        # Return the minimum element
        return nums[low]
        