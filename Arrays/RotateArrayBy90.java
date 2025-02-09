// https://leetcode.com/problems/rotate-image
class Solution {
  
    // Brute Force - Create new ans array and copy in the order by observing a pattern in the indices
    // T.C: O(n^2), S.C: O(n^2)
    public void rotate(int[][] matrix) {
      int n = matrix.length;
      int[][] ans = new int[n][n];
  
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              ans[j][n - 1 - i] = matrix[i][j];
          }
      }
  
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              matrix[i][j] = ans[i][j];
          }
      }
    }

    // Optimal - Transpose and Reverse the Matrix
    // T.C: O(n^2)+O(n^2) , S.C: O(1)
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
