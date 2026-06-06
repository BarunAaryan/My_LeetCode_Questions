class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n = len(matrix)
        m = len(matrix[0])
        # Set initial binary search range
        low = 0
        high = n * m - 1
        while low <= high:
            mid = (low+high)//2
            row = mid//m
            col = mid%m
            # Check if target is found
            if matrix[row][col]==target:
                return True
            elif matrix[row][col]<target:
                low= mid+1
            else:
                high = mid -1

        return False




