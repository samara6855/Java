// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

class Solution {
    // Brute Force - T.C: near to O(n*n)
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int flag=0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]) flag=1;
            }
            if(flag==0) list.add(arr[i]);
        }
        return list;
    }

    // Optimal - O(2*n)
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(list); // O(n)
        return list;
    }
}
