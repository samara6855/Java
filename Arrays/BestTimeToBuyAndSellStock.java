// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    // T.C: O(n), S.C: O(1)
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            profit = Math.max(prices[i]-min,profit);
            min = Math.min(prices[i],min);
        }
        return profit;
    }
}
