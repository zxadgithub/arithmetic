package com.zxa.common;

import java.util.Arrays;

/**
 * Created by 张新安 on 2017/8/21.
 * 面试题12， P89,（回溯法）
 * 矩阵中是否包含制定字符串的路径
 */
public class BackTracking {
    
    public static void main(String[] args) {
        char [][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String str = "acfdec";
        BackTracking backTracking = new BackTracking();
        boolean res = backTracking.hasPath(matrix,matrix.length,matrix[0].length,str);
        System.out.println(res);
    }
    
    private boolean hasPath(char [][]matrix,int rows,int cols,String str){
        if(matrix ==null || rows < 1 || cols < 1 || str == null || str.equals(""))
            return false;
        boolean [][]visited = new boolean[rows][cols];
        for(int i = 0;i<visited.length;i++) {
            Arrays.fill(visited[i], false);
        }
        int pathLength = 0;
        for(int row = 0;row < rows;++row){
            for(int col = 0; col < cols ; ++col ){
                if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String str, int pathLength, boolean[][] visited) {
        
        if(pathLength >= str.length() - 1)
            return true;
        boolean hasPath = false;
    
//        System.out.println("row:"+row+"\t"+"col:"+col+"cols:"+cols+"rows:"+rows+"矩陣："+matrix[row][col]+"字符串"+str.charAt(pathLength)+
//
//        "布爾"+visited[row][col]);
        
        
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength)
                && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;
        
        hasPath = hasPathCore(matrix,rows,cols,row,col - 1,str, pathLength,visited) ||
                hasPathCore(matrix,rows,cols,row - 1,col,str, pathLength,visited) ||
                hasPathCore(matrix,rows,cols,row + 1,col ,str, pathLength,visited) ||
                hasPathCore(matrix,rows,cols,row,col + 1,str, pathLength,visited) ;
        
        if(!hasPath){
            --pathLength;
            visited[row][col] = false;
        }
    }
        
        
        return hasPath;
    }
    
    
}
