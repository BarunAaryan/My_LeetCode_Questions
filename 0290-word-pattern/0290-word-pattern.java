class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mp = new HashMap<>();
        Set<String> set= new HashSet<>();

        String[] arr= s.split(" ");
        //split the string on the basis of spaces 
        int n=arr.length;
        //base case
        if(n!=pattern.length()){
            return false;
        }
        for(int i=0; i<n; i++){
            String word= arr[i];
            char ch= pattern.charAt(i);
            if(mp.containsKey(ch)){
                //if char is already mapped and cannot be mapped with something else
                if(!mp.get(ch).equals(word))
                return false;
            }
            else{
                //if word already used
                if(set.contains(word)){
return false;
                }
                else{
                   mp.put(ch, word);
                   set.add(word); 
                }
            }
        }

        return true;
    }
}