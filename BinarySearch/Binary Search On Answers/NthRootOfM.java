// https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1

class Solution {
  
    // O(logn)
    public int nthRoot(int n, int m) {
        long low = 1;
        long high = m;
        
        while(low<=high){
            long mid = (low+high)/2;
            if(Math.pow(mid,n)<m){
                low=mid+1;
            }else if(Math.pow(mid,n)==m){
                return (int)mid;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
