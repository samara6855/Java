// https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258
public class Solution {
    // Brute Force - Using one more for loop in j loop 'k' from i to j - O(n^3)
    // Better - O(n^2)
    public static int subarraysWithSumK(int []a, int b) {
        int n = a.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int xor = 0;
            for(int j=i;j<n;j++){
                xor = xor^a[j];
                if(xor==b) count++;
            }
            
        }
        return count;
    }

    // Optimal - Using hashmap, finding prefix xor, if exists count, otherwise add it to map
    // O(n) or O(nlogn) depending on map, S.C: O(n)
    public static int subarraysWithXorK(int []a, int k) {
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }
}
