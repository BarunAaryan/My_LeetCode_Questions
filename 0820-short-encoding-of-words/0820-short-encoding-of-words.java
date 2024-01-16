class Solution {
    public int minimumLengthEncoding(String[] words) {
        //first we sort the word array in descending order, and in reversed fashion
        
        Arrays.sort(words, Comparator.comparingInt(String:: length).reversed());
        List<String> encodingList = new ArrayList<>();
        encodingList.add(words[0]);
        //initializing the word with length of first word
        int length = words[0].length();
        for(int i =1; i<words.length; i++){
            //initializing the suffix with not found
            boolean suffixFound = false;
            for(String encoding : encodingList){
                if(encoding.endsWith(words[i])){
                    //if we found the word then break
                    suffixFound = true;
                    break;
                }
            }
            if(!suffixFound){
                encodingList.add(words[i]);
                length += words[i].length();
                
            }
        }
        return length+ encodingList.size();
        //encodingList.size() - this helps to add the # - if two words then we have two #
        
        
    }
}