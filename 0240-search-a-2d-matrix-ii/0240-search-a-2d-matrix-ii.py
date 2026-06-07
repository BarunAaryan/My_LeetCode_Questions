class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n = len(matrix)
        m = len(matrix[0])
        row = 0
        col = m-1
        while row < n and col >=0:
            current = matrix[row][col]
            if current == target:
                return True
            elif current < target:
                row+=1
            else: 
                col-=1
        return False


