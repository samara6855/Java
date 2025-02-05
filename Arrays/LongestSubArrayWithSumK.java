
// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    // Brute Force - Generating all sub arrays and checking - O(n^2)
    public int longestSubarray(int[] arr, int k) {
        int len = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                    sum+=arr[j];
                if(sum==k) len = Math.max(len,j-i+1);
            }
        }
        return len;
    }

    // Better(If array elements are only positive) - Using Hashing - O(n)
    // Optimal(If array elements contain positives and negatives)
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    // Optimal - Two Pointer(Only if array elements are positives)
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length;
        int left = 0, right = 0;
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
}
