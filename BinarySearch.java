package com.simha.java;

public class BinarySRecursion {
    public static void main(String[] args) {
        int[] arr={12,15,16,20,28,32};
        int target = 16;
        System.out.println(BinarySearch(arr,target,0,arr.length-1));
    }

    static int BinarySearch(int[] arr, int target, int s, int e) {
        if(s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target){
            return m;
        }
        if(arr[m]<target){
            return BinarySearch(arr,target,s,m-1);
        }
        return BinarySearch(arr,target,m+1,e);  //Recursive Call
    }
}
