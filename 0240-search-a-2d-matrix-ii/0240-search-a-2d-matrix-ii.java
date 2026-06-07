class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; //number of rows
        int m = matrix[0].length; // number of columns 
        int row =0; //Start at first row
        int col = m-1; // start at first column
        while(row<n && col >=0){
            if(matrix[row][col]==target){
                return true; //Found Target
            }else if(matrix[row][col]<target){
                row++; //Move Down
            }else{
                col--; //Move Left
            }
        }
        return false;
    }
}