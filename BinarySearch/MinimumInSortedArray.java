// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {

    // Brute Force - Finding minimum using loop in the array - O(n)

    // Optimal - Finding the sorted part and taking minimum, and then removing that part and check on the remaining part
    // O(logn)
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    // More optimal - If the search space is sorted, which means arr[low]<=arr[high], arr[low] will be the answer
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;

            // This condition means that the search space is sorted
            // So the nums[low] will be minimum and no need to search in that space
            if(nums[low]<=nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }    
            
            if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
