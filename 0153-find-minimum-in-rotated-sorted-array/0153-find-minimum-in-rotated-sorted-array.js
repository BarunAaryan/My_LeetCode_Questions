/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let low=0, high =nums.length -1;
    while(low<high){
        let mid= Math.floor(low+(high-low)/2);
        if(nums[mid]>nums[high]){
            //Min lies in right half
            low= mid +1;
        }else{
            high=mid;
        }
    }
    //return min element
    return nums[low];
    
};