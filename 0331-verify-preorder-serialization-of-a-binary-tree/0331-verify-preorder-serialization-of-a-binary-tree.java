class Solution {
    public boolean isValidSerialization(String preorder) {
        int cnt= 1;        
        int n = preorder.length();
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') {
                --cnt;
                if (cnt < 0) return false;
                if (preorder.charAt(i - 1) != '#') cnt += 2;
            }
        }

        cnt= (preorder.charAt(n-1) == '#') ? cnt -1: cnt+1;
        return cnt== 0; 
    }
}