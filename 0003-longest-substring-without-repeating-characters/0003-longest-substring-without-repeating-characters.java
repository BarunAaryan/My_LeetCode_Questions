class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
        int left =0, right =0;
        int n = s.length();
        int len=0;
        while(right < n){
            //does map contains the character at the index right
            if(mpp.containsKey(s.charAt(right))){
                left= Math.max(mpp.get(s.charAt(right))+1, left); 
                //mpp.get(s.charAt(right)) whatever index i have seen it last +1
                //we are comparing with left as if it lies to the left of left we don't need to update it 
}
            mpp.put(s.charAt(right), right);
            len= Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
}