// https://leetcode.com/problems/merge-intervals/
class Solution {
    // Brute Force - Sort the array and then search for merging capability on the right
    // T.C: O(n*logn)+O(2*n), S.C: O(n)
    public int[][] merge(int[][] intervals) {
       int n=intervals.length;
       Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int []> ans=new ArrayList<>();
        for(int i=0;i<n;i++){     
        int start=intervals[i][0];
        int end=intervals[i][1];
        if(!ans.isEmpty() && end<=ans.get(ans.size()-1)[1]) continue;
        for(int j=i+1;j<n;j++){
            if(intervals[j][0]<=end) {
                end=Math.max(end,intervals[j][1]);
                start=Math.min(start,intervals[j][0]);
                }
            else break;
        }
        int temp[]={start,end};
        ans.add(temp);
        }
        int[][] result = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
             result[i] = ans.get(i);
        }
        return result;
    }

    // Optimal - T.C: O(nlogn)+O(n), S.C: O(n)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] >= intervals[i][0]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, k + 1);
    }
}
