// https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1

class Solution {
    // Floor - Largest number which is less than or equal to x
    // Ceil - Smallest number which is greater than or equal to x

    // T.C: O(nlogn)+O(logn)
    public int[] getFloorAndCeil(int x, int[] arr) {
        int l=0,r=arr.length-1;
        Arrays.sort(arr);
        
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x)return new int[]{x,x};
            else if(arr[m]<x)l=m+1;
            else r=m-1;
        }
        int a=0,b=0;
        if(l>arr.length-1 || l<0)a=-1;
        else a=arr[l];
        if(r>arr.length-1 || r<0)b=-1;
        else b=arr[r];
        
        return new int[]{b,a};
    }
}
