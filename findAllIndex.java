package com.simha.java;

import java.util.ArrayList;

public class findAllIndex {
    public static void main(String[] args) {
        int[] arr={1,4,5,8,5,15,25};
        int target = 5;

        System.out.println(findAllIndex(arr,target,0,new ArrayList<>()));
    }

    static ArrayList findAllIndex(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length-1){
            return list;
        }
        if(target==arr[index]){
            list.add(index);//adding index
        }

        return findAllIndex(arr,target,index+1,list);
    }
}
