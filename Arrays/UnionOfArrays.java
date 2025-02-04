// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
class Solution {
    // Brute Force Approach
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        for(int j=0;j<b.length;j++){
            set.add(b[j]);
        }
        for(int num:set){
            list.add(num);
        }
        return list;
    }
  
    // Optimal Approach - Two Pointer
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int m=a.length;
        int n=b.length;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(a[i]<=b[j]){
                if(list.size()==0 || list.get(list.size()-1) != a[i]){
                    list.add(a[i]);
                }
                i++;
            }else{
                if(list.size()==0 || list.get(list.size()-1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }
        while(i<m){
            if(list.size()==0 || list.get(list.size()-1) != a[i]){
                    list.add(a[i]);
                }
                i++;
        }
        while(j<n){
            {
                if(list.size()==0 || list.get(list.size()-1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }
        return list;
    }
}
