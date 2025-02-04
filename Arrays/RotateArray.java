https://leetcode.com/problems/rotate-array/
class Solution {
    // Brute Force - Left Rotate
    public static void Rotatetoleft(int[] arr, int n, int k) {
    if (n == 0)
      return;
    k = k % n;
    if (k > n)
      return;
    int[] temp = new int[k];
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }
    for (int i = 0; i < n - k; i++) {
      arr[i] = arr[i + k];
    }
    for (int i = n - k; i < n; i++) {
      arr[i] = temp[i - n + k];
    }
    }
  
    // Brute Force - Right Rotate
    public void rotateRight(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) return;
    k = k % n;
    if (k > n)
      return;
    int[] temp = new int[k];
    for (int i = n - k; i < n; i++) {
      temp[i - n + k] = nums[i];
    }
    for (int i = n - k - 1; i >= 0; i--) {
      nums[i + k] = nums[i];
    }
    for (int i = 0; i < k; i++) {
      nums[i] = temp[i];
    }
    }
  
    // Optimal Approach - Using 3 reversals
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
