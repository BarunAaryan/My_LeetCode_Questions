class Solution(object):
    # Function to calculate total hours at given speed
    def calculateTotalHours(self, piles, speed):
        totalH=0
        for bananas in piles:
            totalH += (bananas + speed - 1) // speed
        return totalH
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        maxPile= max(piles)
        low, high = 1, maxPile
        ans = maxPile
        #Binary Search on answer space
        while(low<=high):
            mid = (low + high) // 2
            totalH = self.calculateTotalHours(piles, mid)
             # If possible, try smaller speed
            if totalH <= h:
                ans = mid
                high = mid - 1
            # Otherwise, try larger speed
            else:
                low = mid + 1

        return ans
        