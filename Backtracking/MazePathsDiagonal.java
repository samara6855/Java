package Backtracking;

public class MazePathDiagonal {
    public static void main(String[] args) {
        MazePathsDiagonal("",3,3);
    }

    static void MazePathsDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1&&c>1){
            MazePathsDiagonal(p+'D',r-1,c-1);
        }
        if(r>1){
            MazePathsDiagonal(p+'V',r-1,c);
        }
        if(c>1){
            MazePathsDiagonal(p+'H',r,c-1);
        }
    }

}
