class Solution(object):
    def is_possible(self, bloomDay, day, m , k):
        count =0;
        bouquets=0;
        for bloom in bloomDay:
            if bloom<=day:
               count+=1
               if count ==k:
                bouquets+=1 #one bouquet formed
                count=0
            else:
                count=0 #reset if a flower is not ready
        return bouquets>=m
    

    def minDays(self, bloomDay, m, k):
        """
        :type bloomDay: List[int]
        :type m: int
        :type k: int
        :rtype: int
        """
        if m*k>len(bloomDay):
            return -1 #not enough flowers
        low = min(bloomDay)
        high = max(bloomDay)
        answer =-1
        while low<=high:
            mid = (low+high)//2
            if self.is_possible(bloomDay, mid , m ,k):
                answer = mid #try to find smaller day
                high = mid -1 
            else:
                low = mid+1 #need more days 
        return answer
        