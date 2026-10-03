class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        children = sorted(g)
        cookies = sorted(s)

        child_index = 0
        cookie_index = 0

        while child_index < len(children) and cookie_index < len(cookies):
            if children[child_index] <= cookies[cookie_index]:
                child_index+=1

            cookie_index+=1

        return child_index
        