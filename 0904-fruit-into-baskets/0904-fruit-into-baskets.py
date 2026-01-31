class Solution(object):
    def totalFruit(self, fruits):
        """
        :type fruits: List[int]
        :rtype: int
        """
        maxlen =0
        lastfruit = secondlastfruit= -1
        currcount = lastfruitstreak =0
        #Traverse through fruit array
        for fruit in fruits:
            #if currFruit matches last two, increase the window size
            if fruit == lastfruit or fruit == secondlastfruit:
                currcount +=1
            else:
                #Otherwise reset to streka size
                currcount = lastfruitstreak +1
            # Update last fruit streak and tracking
            if fruit == lastfruit:
                lastfruitstreak+=1
            else:
                lastfruitstreak=1
                secondlastfruit = lastfruit
                lastfruit = fruit
            maxlen = max(maxlen, currcount)
        return maxlen
        