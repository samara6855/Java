package com.yssr.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class numsWithEvenNoDigits {
    public static void main(String[] args) {
        int[] arr = { 12, 4, 3245, 234, 1232, 15};
        System.out.println(findNumbers(arr));
    }

    private static ArrayList<Integer> findNumbers(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(even(num)){
                list.add(num);
            }
        }
        return list;
    }

    private static boolean even(int num) {
        int nodigits = digits(num);
        return nodigits%2==0;
    }

    private static int digits(int num) {
        return (int)(Math.log10(num))+1;
    }
}
