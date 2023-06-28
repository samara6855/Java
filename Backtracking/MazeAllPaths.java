package Backtracking;

public class MazeAllPaths {
    public static void main(String[] args) {

        boolean[][] maze={
                {true,true,true},
                {true,true,true},
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

        maze[r][c]=false;

        if(r<maze.length-1){
            MazePathObstacle(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            MazePathObstacle(p+'R',maze,r,c+1);
        }
        if(r>0){
            MazePathObstacle(p+'U',maze,r-1,c);
        }
        if(c>0){
            MazePathObstacle(p+'L',maze,r,c-1);
        }

        maze[r][c]=true;
    }
}
