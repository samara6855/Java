// https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

class Solution {

    // Brute Force - Looping through the array and counting - O(n)

    // Optimal - Binary Search, On top of Finding First And Last Occurence in the Array,
    // As the Array is sorted, we can directly return the difference between the two indices
    // O(logn)
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int start=-1,end=-1;
        start = search(arr, target, true);
        end = search(arr, target, false);
        
        if(start==-1) return 0;
        return end-start+1;
    }
    int search(int[] nums, int target, boolean findstartIndex){
        int ans=-1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if(findstartIndex){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
