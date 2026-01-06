class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //All Ascii chars
        int HashLen = 256;
        //hashtable to store last occurence of each char
        int[] hash = new int[HashLen];
        //Initialize the table with -1
        Arrays.fill(hash,-1);
        int l=0, r=0, maxLen=0;
        while(r<n){
            //If current character s.charAt(r) is already in the substring
            if(hash[s.charAt(r)] >= l){
                //Move left pointer to the right of the last occurence of s.charAt(r)
            l= Math.max(hash[s.charAt(r)]+1, l);
            }
            int len = r-l+1;
            maxLen= Math.max(len, maxLen);
            //store the index of current chatacter in the hash table
            hash[s.charAt(r)] =r;
            r++;
        }
        return maxLen;
    }
}