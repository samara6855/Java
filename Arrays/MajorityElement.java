// https://leetcode.com/problems/majority-element/
class Solution {
    // Brute Force - Checking the entire array for each element and counting - O(n^2)
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            if (cnt > (n / 2))
                return nums[i];
        }

        return -1;
    }

    // Better - Hashing - T.C: O(nlogn)+O(n) S.C: O(n)
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i],value+1);
        }

        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(it.getValue()>(n/2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    // Optimal - Moore's Voting Algorithm - O(n)
    public int majorityElement(int[] nums) {
        int c = 0;
        int el = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(c==0) el=nums[i];
            if(nums[i]==el) c++;
            else c--;
        }
        return el;
    }
}
