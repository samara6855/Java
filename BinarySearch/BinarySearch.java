// https://leetcode.com/problems/binary-search/

class Solution {

    // T.C: O(logn)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                high=mid-1;
            }else if(target>nums[mid]){
                low=mid+1;
            }
        }
        return -1;
    }
}
