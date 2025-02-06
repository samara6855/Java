// https://leetcode.com/problems/sort-colors/
class Solution {
    // Brute Force - Use any sorting algorithm - For example: Merge Sort - TC - O(nlogn), SC - O(n)
  
    // Better Approach - O(2n)
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) c0++;
            else if(nums[i]==1) c1++;
            else c2++;
        }
        int in = 0;
        for(int i=0;i<c0;i++){
            nums[in] = 0;
            in++;
        }
        for(int i=0;i<c1;i++){
            nums[in] = 1;
            in++;
        }
        for(int i=0;i<c2;i++){
            nums[in] = 2;
            in++;
        }
    }

    // Optimal - Deutch National Flag Algorithm - O(n)
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1) mid++;
            else{
                swap(nums,mid,high);
                high--;
            }
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
