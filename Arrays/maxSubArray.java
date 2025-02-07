// https://leetcode.com/problems/maximum-subarray/
class Solution {
    // Brute Force & Better - O(n^2)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    // Optimal - Kadane's Algorithm - O(n)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum> maxSum) maxSum = sum;
            if(sum<0) sum = 0;
        }
        return maxSum;
    }

    // Follow Up - If asked to return subarray as well - O(n)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum==0) int start = i;
            sum+=nums[i];
            if(sum> maxSum) {
              maxSum = sum;
              ansStart = start;
              ansEnd = i;
            }
            if(sum<0) sum = 0;
        }
        return maxSum;
    }
}
