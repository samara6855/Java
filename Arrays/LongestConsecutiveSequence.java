// https://leetcode.com/problems/longest-consecutive-sequence
class Solution{
  // Brute Force - Pick and do linear search for next consecutive numbers - T.C: Near to O(n^2)
  public static boolean linearSearch(int []a, int num) {
        int n = a.length; //size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }
    public static int longestSuccessiveElements(int []a) {
        int n = a.length; //size of array
        int longest = 1;
        //pick a element and search for its
        //consecutive numbers:
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int cnt = 1;
            //search for consecutive numbers
            //using linear search:
            while (linearSearch(a, x + 1) == true) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    // Better - Sort array and check for consecutive sequence 
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int maxLen = 1;
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if (nums[i] == nums[i - 1]) continue;
            if(nums[i]-nums[i-1]==1){
                len++;
            }else{
            maxLen = Math.max(len,maxLen);
            len = 1;
            }
        }
        return Math.max(maxLen,len);
    }

    // Optimal - Using Set - T.C: O(3*n), S.C: O(n)
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
