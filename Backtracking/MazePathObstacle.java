package Backtracking;

public class MazePathObstacle {
    public static void main(String[] args) {

        boolean[][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        MazePathObstacle("",maze,0,0);
    }

    static void MazePathObstacle(String p,boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            MazePathObstacle(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            MazePathObstacle(p+'R',maze,r,c+1);
        }
    }

}
