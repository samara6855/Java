// https://leetcode.com/problems/merge-sorted-array
class Solution {

    // Brute Force - Storing answer in a new array by looping through both arrays and checking for nums1[p1]<nums[p2], and again
    // storing it in the nums1 from ans array. T.C: O(2*(m+n)), S.C: O(m+n)
    
    // Optimal - T.C: O(m+n), S.C: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while(p2>=0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
