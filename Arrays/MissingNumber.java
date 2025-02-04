// https://leetcode.com/problems/missing-number/
class Solution {
    // Brute Force - Search from 1 to size in the array
    // Better - Using a hash array and then checking the index with value 0
    // Optimal using Sum
  
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;
        int s = 0;
        for(int i:nums) s+=i;
        return sum-s;
    }
    // Optimal can also be done using XOR
}
