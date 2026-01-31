class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        left=0
        zerocount=0
        maxlen=0
        for right in range(len(nums)):
            #Increment zerocount if element is 0
            if nums[right]==0:
                zerocount+=1
            #If zerocount exceeds k , shirnk to the left
            if zerocount >k:
                if nums[left]==0:
                    zerocount-=1
                #Move left pointer forward
                left+=1

            # Update maxlen with current window size 
            maxlen = max(maxlen, right- left +1)
        return maxlen
        