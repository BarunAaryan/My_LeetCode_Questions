class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        n= len(s)
        HashLen = 256
        """ Hash table to store last
            occurrence of each character """
        hash = [-1] * HashLen
        for i in range(HashLen):
            hash[i] = -1
        l,r, maxLen = 0,0,0
        while r< n:
            """ If current character s[r] 
                is already in the substring    """
            if hash[ord(s[r])] !=-1:
                l = max(hash[ord(s[r])] +1, l)
            current_len = r-l+1
            maxLen= max(current_len, maxLen)
            #Store the index of the currentcharacter in the hash table
            hash[ord(s[r])] = r   
            # Move right pointer to next position
            r += 1
        
        # Return the maximum length found
        return maxLen       