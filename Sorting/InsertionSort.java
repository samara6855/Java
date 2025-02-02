class Solution {
    // Problem Link: https://www.geeksforgeeks.org/problems/insertion-sort/1
    public void insertionSort(int arr[]) {
        for(int i=0;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                
                j--;
            }
        }
    }
}
