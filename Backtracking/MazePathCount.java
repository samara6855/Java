package Backtracking;

public class MazePathCount {
    public static void main(String[] args) {
        System.out.println(MazeCount(3,3));
    }
    static int  MazeCount(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left=MazeCount(r-1,c);
        int right=MazeCount(r,c-1);

        return left+right;
    }
}
