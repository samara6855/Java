//
class Solution {

    // Brute Force - T.C: O(n^3), S.C: O(1)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Traverse the matrix and mark elements as -1 if they belong to a row/col containing 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark entire row
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = -1; // Marking as -1
                        }
                    }
                    // Mark entire column
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = -1; // Marking as -1
                        }
                    }
                }
            }
        }

        // Step 2: Replace all -1 values with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
  
    // Better - Assign 1's by creating to new arrays row and col and set 1's, and then reiterate those arrays to fill zeroes
    // T.C: O(2*n*m), S.C: O(n+m)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] column = new int[m];
        Arrays.fill(row, 0);
        Arrays.fill(column, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || column[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

   // Optimal - T.C: O(2*(n*m)), S.C: O(1)
   public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col0 = false; // Flag for the first column

        // Step 1: Mark rows & columns using the first row and first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = true; // If any element in first column is 0, mark col0
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark first column
                    matrix[0][j] = 0; // Mark first row
                }
            }
        }

        // Step 2: Set matrix elements to zero based on markers (backward traversal)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // Handle first column separately
            if (col0) matrix[i][0] = 0;
        }
    }
}
