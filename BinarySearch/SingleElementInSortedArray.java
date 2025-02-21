// https://leetcode.com/problems/single-element-in-a-sorted-array/

class Solution {

    // Brute Force - Checking on left and right for the same element - O(n)
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            if(i==0 && nums[i]!=nums[i+1]){
                return nums[i];
            }
            if(i==n-1 && nums[i-1]!=nums[i]){
                return nums[i];
            }
            if(nums[i]!=nums[i+1]&&nums[i-1]!=nums[i]){
                return nums[i];
            }
        }
        return 0;
    }

  
    // Brute Force - Using XOR Concept - O(n)
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }

    // Optimal - O(logn)
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }   
}
