class Solution {
    public boolean containsDuplicate(int[] nums) {
        //create a hashset
        Set<Integer> intSet = new HashSet<>();
        //iterate over each element 
        for(int num: nums){
            //check number in hashset
            if(intSet.contains(num)){
                return true;
            }
            //add the number to the hashset
            intSet.add(num);
        }
        return false;
    }
}