class Solution {
    public int maxDepth(String s) {
        int ans =0,opening =0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='('){
                opening++;
            }else if(s.charAt(i)==')'){
                opening--;
            }
            ans = Math.max(ans, opening);
        }
        return ans;
        
    }

}