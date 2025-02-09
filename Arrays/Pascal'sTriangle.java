// https://leetcode.com/problems/pascals-triangle

class Solution {
    // Brute Force - Use Formula to generate the each value of pascal's triangle and fill it in the list
    // T.C: O(n*n*r) -> near to O(n^3)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            List<Integer> tempLst = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static int nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    // Optimal - Using the generate row from 2nd Approach - T.C: O(n^2)
    class Solution {
      public List<List<Integer>> generate(int numRows) {
          List<List<Integer>> ans = new ArrayList<>();
  
          for (int row = 1; row <= numRows; row++) {
              ans.add(generateRow(row));
          }
          return ans;
      }
  
      public static List<Integer> generateRow(int row) {
          long ans = 1;
          List<Integer> ansRow = new ArrayList<>();
          ansRow.add(1);
          for (int col = 1; col < row; col++) {
              ans = ans * (row - col);
              ans = ans / col;
              ansRow.add((int)ans);
          }
          return ansRow;
      }
    }
}
