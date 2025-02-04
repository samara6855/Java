// https://leetcode.com/problems/single-number
class Solution {
    // Brute Force Approach - Search and Count
    public static int getSingleElement(int []arr) {
        int n = arr.length;
        //Run a loop for selecting elements:
        for (int i = 0; i < n; i++) {
            int num = arr[i]; // selected element
            int cnt = 0;
            //find the occurrence using linear search:
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    cnt++;
            }
            // if the occurrence is 1 return ans:
            if (cnt == 1) return num;
        }
        return -1;
    }

    // Better Approach 1 - Using Hash Array
    // Using array hashing it is difficult to hash the elements of the array if it contains negative numbers or a very large number.
    public static int getSingleElement(int []arr) {
        int n = arr.length;

        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1;
    }
  
    // Better Approach 2 - Using HashMap
    public static int getSingleElement(int []arr) {
        int n = arr.length;

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }
    
    // Optimal - Using XOR
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    
    }
}
