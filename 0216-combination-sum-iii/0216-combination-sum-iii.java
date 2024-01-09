class Solution {
    public void help(int i, int k, int sumTillNow, int n, List<Integer> subSet, List<List<Integer>> ans){
        //base case
        //if the sum till now becomes gretaer than n then we don't need to proceed
        if(sumTillNow > n){
            return;
        }
        // If k becomes equal to zero(0) , we need to check if the Sum-Till-Now is equal to n or not
if(k==0){
    //if sum till now equal to n, include it in the ans
    if(sumTillNow==n){
        ans.add(new ArrayList(subSet));
    }
    return;
}
        if(i==10){
            return;
        }
        sumTillNow += i ;
        subSet.add(i) ;
        // Ask Recursion to do the rest of the task
        help(i + 1, k - 1, sumTillNow, n, subSet, ans) ;
        // Backtrack and undo the change we have done
        sumTillNow -= i ;
        subSet.remove(subSet.size()-1) ;
        // We don't include the i-th Number and ask recursion to do the rest of the Combinations
        help(i + 1, k, sumTillNow, n, subSet, ans); 
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        help(1, k, 0, n, subSet, ans) ;
        return ans ;
    }
}