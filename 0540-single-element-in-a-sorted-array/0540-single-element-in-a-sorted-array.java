class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Get the size of the array
        int n =nums.length;
        //Edge Case: Only one element in the array
        if(n==1) return nums[0];
        //Edge Case: First Element is the unique one
        if (nums[0] != nums[1]) return nums[0];
        //Edge Case: Last Element is the unique one
        if (nums[n-1]!= nums[n-2]) return nums[n-1];

        int low=1, high = n-2;
        //Perform Binary Search
        while(low<=high){
            int mid =  low+(high-low)/2;
            //Check if middle element is the unique one
            if(nums[mid]!= nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || //odd
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                // Move to the right half
                low = mid + 1;
            }
            // If mid is in the right half (pairing broken earlier)
            else {
                // Move to the left half
                high = mid - 1;
            }
        }

        // Dummy return (not reachable if input is valid)
        return -1;
        }
        
    }
