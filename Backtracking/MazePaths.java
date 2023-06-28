package Backtracking;

public class MazePaths {
    public static void main(String[] args) {
        MazePaths("",3,3);
    }

    static void MazePaths(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            MazePaths(p+'D',r-1,c);
        }
        if(c>1){
            MazePaths(p+'R',r,c-1);
        }
    }

}
