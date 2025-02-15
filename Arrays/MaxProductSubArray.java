//

class Solution {

    // Brute Force - On top of Better, Using one more loop 'k' from i to j, and multiplying - Near to O(n^3)
    
    // Better - Near to O(n^2)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            long product = nums[i];
            for(int j=i+1;j<n;j++){
                product*=nums[j];
                if(product>maxProduct){
                    maxProduct = product;
                }
            }
        }
        if(n==1) maxProduct=nums[0];
        return (int)maxProduct;
    }

    // Optimal - O(n)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix = 1;
            if(suffix==0) suffix = 1;

            prefix*=nums[i];
            suffix*=nums[n-i-1];
            maxProduct = Math.max(maxProduct, Math.max(prefix,suffix));
        }

        return maxProduct;
    }
}
