// https://leetcode.com/problems/find-peak-element

class Solution {
  
    // Brute Force - O(n)
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i - 1] < nums[i])
                    && (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    // Optimal - O(logn)
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;
        int start =1;
        int end = arr.length - 2;
        while (start <= end ){
            int mid = start + (end - start) / 2;
            if((arr[mid]>arr[mid-1]) && (arr[mid]>arr[mid+1])){
                return mid;
            }else if(arr[mid]>arr[mid-1]) {
                start=mid+1;
            }else end=mid-1;
        }
        return -1;
    }
}
