// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {

    // Brute Force - O(n)
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target) return true;
        }
        return false;
    }

    // Optimal - Average: O(logn), Highest: O(n/2)
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;

            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]) high = mid-1;
                else low = mid+1;
            }else{
                if(nums[mid]<target && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}
