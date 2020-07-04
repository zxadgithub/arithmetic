package zxa.backtrack;

import java.util.Arrays;

/**
 * Created by 张新安 on 2017/8/22.
 * P92 Q13 机器人的运动范围
 */
public class RobotRange {
    
    public static void main(String[] args) {
        RobotRange robotRange = new RobotRange();
//        int s = robotRange.check(2);
//        System.out.println(s);
        int count = robotRange.moveCount(3,3,3);
        System.out.println(count);
    }
    
    public int moveCount(int k, int rows, int cols){
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0;i < visited.length; i++){
            Arrays.fill(visited[i],false);
        }
        int count = movintCountcore(rows, cols ,0 ,0, k, visited);
        return count;
    }
    
    int movintCountcore(int rows, int cols, int row, int col, int k, boolean[][] visited){
    
        int count = 0;
        
        if( row >= 0 && col >=0 && row < rows && col < cols && check(row) + check(col) <= k && !visited[row][col]){
            visited[row][col] = true;
            count = 1 + movintCountcore(rows, cols ,row + 1 ,col , k, visited)
                    + movintCountcore(rows, cols ,row ,col + 1 , k, visited)
                    + movintCountcore(rows, cols ,row ,col - 1 , k, visited)
                    + movintCountcore(rows, cols ,row - 1 ,col , k, visited);
        }
        return  count;
    }
    
    
    
    public int check(int x){
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return  sum;
    }
}
