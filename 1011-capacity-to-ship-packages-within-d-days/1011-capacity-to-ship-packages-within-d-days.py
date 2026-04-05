class Solution(object):
    def daysRequired(self, weights, capacity):
        days=1
        currentLoad=0
        for w in weights:
            if currentLoad+w>capacity:
                days+=1
                currentLoad=w
            else:
                currentLoad+=w
        return days

    def shipWithinDays(self, weights, days):
        """
        :type weights: List[int]
        :type days: int
        :rtype: int
        """
        low = max(weights)
        high = sum(weights)
        
        while(low<=high):
            mid = low +(high -low)//2
            needed = self.daysRequired(weights, mid)
            if needed<= days:
                high = mid-1
            else:
                low= mid+1
            
        return low
