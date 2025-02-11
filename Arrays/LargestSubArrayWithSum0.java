// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
class Solution {
    // Brute Force - O(n^2)
    int maxLen(int arr[]) {
       int  max = 0;
    	for(int i = 0; i < arr.length; ++i){
    		int sum = 0;
    		for(int j = i; j < arr.length; ++j){
    			sum += arr[j];
    			if(sum == 0){
    				max = Math.max(max, j-i+1);
    			}
    		}
    	}
	return max;
    }

    // Optimal - Using Hashing - T.C: O(n), S.C: O(n)
    int maxLen(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0; 
        for(int i = 0;i<n;i++) {
            sum += arr[i]; 
            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {
                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
}
