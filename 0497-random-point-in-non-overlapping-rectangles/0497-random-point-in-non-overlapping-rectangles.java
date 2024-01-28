class Solution {
     int[][] rect;
    int x, y;
    int i = 0;

    public Solution(int[][] rects) {
         rect = rects;
        x = rect[i][0];
        y = rect[i][1];
    }
    
    public int[] pick() {
        int[] ans = {x,y};
        x++;
        if(x > rect[i][2]) {
            x = rect[i][0];
            y++;
        }
        if(y > rect[i][3]) {
            if(i+1 < rect.length) {
                i++;
            }else {
                i = 0;
            }
            x = rect[i][0];
            y = rect[i][1];
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */