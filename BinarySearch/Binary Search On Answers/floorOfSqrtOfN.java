// https://www.geeksforgeeks.org/problems/square-root/0

class Solution {

    // Math method: Math.sqrt(n);
  
    // O(logn)
    int floorSqrt(int n) {
        long low = 1;
        long high = n;
        while(low<=high){
            long mid = (low+high)/2;
            long val = (mid*mid);
            if(val<=n){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (int)high;
    }
}
