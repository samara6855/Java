// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    // Brute Force - Near to O(n^2)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }      
        return count;
    }

    // Optimal - T.C: O(n), S.C: O(n) - Hashmap average time complexity is O(1)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
