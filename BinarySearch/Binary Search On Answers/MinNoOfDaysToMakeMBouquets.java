// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

class Solution {
    
    // Brute Force - O((maxi - mini+1)*n)
    public int minDays(int[] bloomDay, int m, int k) {
        if((m * k) > bloomDay.length) {return -1;}
        int mini = Arrays.stream(bloomDay).min().getAsInt();
        int maxi = Arrays.stream(bloomDay).max().getAsInt();
        for(int i=mini; i<=maxi; i++){
            if(countDay(bloomDay, i, m, k) == true){return i;}
        }
        return -1;
    }
    
    private boolean countDay(int[]arr, int day, int m, int k){
        int count = 0, noOfBouque = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfBouque += (count/k);
                count = 0;
            }
        }
        noOfBouque += (count/k);
        if(noOfBouque >= m){return true;}
        else{return false;}
    }

    // Optimal - Binary Search - O(log(maxi - mini+1)*n)
    public int minDays(int[] arr, int m, int k) {
        long val = (long) m * k;
        int n = arr.length;
        if (val > n) return -1; 
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (countDay(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private boolean countDay(int[] arr, int day, int m, int k) {
    int n = arr.length; 
        int count = 0, noOfBouque = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                noOfBouque += (count / k);
                count = 0;
            }
        }
        noOfBouque += (count / k);
        return noOfBouque >= m;
    }
  
}
