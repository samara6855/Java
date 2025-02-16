// https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

class Solution {
    static int findFloor(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int res = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=k){
                res=mid;
                low = mid+1;
            }else if(arr[mid]>k){
                high=mid-1;
            }
        }
        return res;
    }
}
