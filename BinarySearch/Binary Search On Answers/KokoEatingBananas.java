// https://leetcode.com/problems/koko-eating-bananas

class Solution{

  // Brute Force - O(max(arr[])*n)
  public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minimumRateToEatBananas(int[] v, int h) {
        //Find the maximum number:
        int maxi = findMax(v);

        //Find the minimum value of k:
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(v, i);
            if (reqTime <= h) {
                return i;
            }
        }

        //dummy return statement
        return maxi;
    }

    // Optimal 
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int totalHours = 0;
            
            for (int pile : piles) {
                totalHours += Math.ceil(pile / (double) mid);
            }
            
            if (totalHours > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
  
}
