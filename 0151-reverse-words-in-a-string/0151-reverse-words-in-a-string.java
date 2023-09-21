class Solution {
    public String reverseWords(String s) {
        int i = s.length()-1;
        String ans="";
        while(i>=0){
            //removing the case where we have spaces after the end og the sentence
            while(i>=0 && s.charAt(i) == ' ')
            i--;
            int j=i;
            if(i<0)break;
            while(i>=0 && s.charAt(i)!= ' ')
            i--;
            if(ans.isEmpty()){
            ans = ans.concat(s.substring( i+1, j+1));
            //i+1 becasue we started from space and j+1 because last word is non inclusive
            }else{
               ans = ans.concat(" "+s.substring( i+1, j+1));
            }

        }
        return ans;
    }
}