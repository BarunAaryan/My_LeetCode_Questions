class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int [][] result = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0 ; j<n; j++){
                int sum =0, count =0;
                for(int x=i-1; x<=i+1; x++){
                    for(int y=j-1; y<=j+1; y++){
                        if(0<=x && x< m && 0<=y && y<n){
                            sum+= img[x][y] & 255;
                            count += 1;
                        }
                    }
                }
                result[i][j] = (sum/count)<<8;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j]= result[i][j] >>8;
            }
        }
        return result;
    }
}