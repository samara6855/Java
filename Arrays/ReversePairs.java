// https://leetcode.com/problems/reverse-pairs/

class Solution {

    // Brute Force - O(n^2)
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>2*nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal - Using Merge Sort Concept - T.C: O(2*nlogn), S.C: O(n)
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }
  
    public void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while(left <= mid) temp.add(arr[left++]);
        while(right <= high) temp.add(arr[right++]);
        for(int i=low; i<=high; i++) {
            arr[i] = temp.get(i-low);
        }
    } 

    public int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for(int i=low; i<=mid; i++) {
            while(right <= high && (long) arr[i] > 2L * arr[right])
            right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr,low,mid);
        cnt += mergeSort(arr,mid+1,high);
        cnt += countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }

}
