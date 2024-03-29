class Solution {
     public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int c=0;
            StringBuilder str=new StringBuilder();
            
            for(int j=i;j<nums.length;j++){
                if(nums[j]%p==0) c++;
                if(c>k) break;
                str.append(nums[j]+" ");
                set.add(str.toString());
            }
        }
        return set.size();
    }
}