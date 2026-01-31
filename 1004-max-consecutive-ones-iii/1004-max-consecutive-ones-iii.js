/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestOnes = function(nums, k) {
    let left = 0;
    let zerocount =0;
    let maxlen =0;
    for (let right=0; right<nums.length; right++){
        //if current element is zero, increase zeroocount
        if(nums[right]===0){
            zerocount++;
        }
        //if zerocount exceeds k, move left and adjust 
        if(zerocount>k){
            if(nums[left]===0){
                zerocount--;
            }
            //shrink
            left++;
        }
        maxlen= Math.max(maxlen, right-left+1);
    }
    return maxlen;
};