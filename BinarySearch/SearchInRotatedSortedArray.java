// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {

    // Brute Force - O(n)
    public int search(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }

    // Optimal - O(logn)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]) high = mid-1;
                else low = mid+1;
            }else{
                if(nums[mid]<target && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}
