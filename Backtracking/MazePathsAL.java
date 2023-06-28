package Backtracking;

import java.util.ArrayList;

public class MazePathsAL {
    public static void main(String[] args) {
        System.out.println(MazePathsAL("",3,3));
    }
    static ArrayList<String> MazePathsAL(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
          list.addAll(MazePathsAL(p+'D',r-1,c));
        }
        if(c>1){
            list.addAll(MazePathsAL(p+'R',r,c-1));
        }

        return list;

    }
}
