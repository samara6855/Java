// https://leetcode.com/problems/two-sum/
class Solution {
    // Brute Force - Running 2 loops to check for each pair - O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    // Slightly Better - To check elements from i+1 to n - Near to O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    // Better - Using HashMap, Optimal - If we need to indices of the numbers - O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0]=ans[1]=-1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int needed = target - num;
            if(map.containsKey(needed)){
                ans[0] = map.get(needed);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    // Optimal - If only we need to return "YES" or "NO" that the pair exists - O(n log n)
    public boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target) return "YES";
            else if(nums[i]+nums[j]>target) j--;
            else i++;
        }
        return "NO";
    }    
  
}
