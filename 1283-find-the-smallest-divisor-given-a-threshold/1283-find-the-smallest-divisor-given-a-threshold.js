/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */

var sumByD= function(nums, div){
    let sum=0;
    for (let num of nums){
        sum += Math.floor((num + div - 1) / div);
    }
    return sum;
}
var smallestDivisor = function(nums, threshold) {
    if(nums.length > threshold){
        return -1;
    }
    let low =0;
    let high = Math.max(...nums);
    //BS on answer
    while (low < high){
        let mid = Math.floor((low + high) / 2);

        if (sumByD(nums, mid) <= threshold){
            high = mid;
        } else {
            low = mid + 1;
        }
    }return low;
};