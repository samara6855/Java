// https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

class Solution {
    // Brute Force - O(n^2)
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int r = 0;
        int m = 0;
        
        for(int i=1;i<n+1;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j]==i){
                    count++;
                }
            }
            if(count==2) r=i;
            if(count==0) m=i;
        }
        list.add(r);
        list.add(m);
        return list;
    }

    // Better - Using Hash Array - T.C: O(2*n), S.C: O(n)
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int r = 0;
        int m = 0;
        int[] hasharr = new int[n+1];
        for(int i=0;i<n;i++) hasharr[arr[i]]++;
        for(int i=1;i<n+1;i++){
            if(hasharr[i]==2){
                r=i;
            }
            if(hasharr[i]==0) m=i;
        }
        list.add(r);
        list.add(m);
        return list;
    }

    // Optimal - Using Maths - O(n)
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        long s = 0, s2 = 0;
        for(int i=0;i<n;i++){
            s += arr[i];
            s2 += arr[i]*arr[i];
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x - val1;
        list.add((int)x);
        list.add((int)y);
        return list;
    }
  
}
