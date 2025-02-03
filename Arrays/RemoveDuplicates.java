// https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1529864728/

class Solution {
    // Brute Force
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                nums[index++] = num;
            }
        }
        return index;
        
    }
  
    // Optimal Approach - Using Two Pointers
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++; 
                nums[j] = nums[i]; 
            }
        }
        return j + 1; 
    }
}
