class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int targetPointer =0, streamPointer=1;
        while(targetPointer < target.length){
        ans.add("Push");
        if(target[targetPointer] == streamPointer){
            targetPointer++;
        }else{
            ans.add("Pop");
        }
        streamPointer++;
        }
        return ans;
        
    }
}