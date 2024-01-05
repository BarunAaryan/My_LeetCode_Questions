/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxSumBST(TreeNode root) {
        max=0;
        ans(root);
        return max;
    }
    int max=0;
    class Pair{
        int sum, max, min;
        boolean bst;
        Pair(int s){
            sum=s;
        }
        Pair(int s, boolean b, int lmax, int rmin){
            sum= s;
            bst= b;
            max= lmax;
            min= rmin;
        }
    }
    public Pair ans(TreeNode n){
        if(n== null){
            return new Pair(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if(n.left == null && n.right == null){
            if(max<n.val){
                max= n.val;
            }
            return new Pair(n.val, true, n.val, n.val);
        }
        Pair lp = ans(n.left);
        Pair rp = ans(n.right);
        Pair np = new Pair(lp.sum+ rp.sum+ n.val);
        if(n.val >lp.max && n.val <rp.min && lp.bst && rp.bst){
            np.bst = true;
            if(max<np.sum){
                max= np.sum;
            }
        }else{
            np.bst= false;
        }
        np.min= Math.min(n.val, lp.min);
        np.max= Math.max(n.val, rp.max);
        return np;
    }
    
}