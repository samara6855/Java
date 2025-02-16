// https://www.naukri.com/code360/problems/lower-bound_8165382

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
