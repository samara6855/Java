// https://leetcode.com/problems/max-consecutive-ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxC = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                maxC = Math.max(count,maxC);
            }else{
                count=0;
            }
        }
        return maxC;
    }
}
