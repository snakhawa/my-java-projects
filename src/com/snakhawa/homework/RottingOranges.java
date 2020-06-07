package com.snakhawa.homework;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {

    public static void main(String[] args) {

        int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(grid);

    }
    public static int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int row = 0; row < grid.length ; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[]{row,col});
                }
                else if(grid[row][col] == 1)
                {
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) return -1;
        int minutes = 0;
        while(!queue.isEmpty()){
            ++minutes;
            int size = queue.size();
            for(int i=0; i< size; i++){
                int[] point = queue.remove();
                int[][] cells = {{point[0]+1,point[1]}, {point[0]-1,point[1]}, {point[0],point[1]+1}, {point[0],point[1]-1}};

                for(int[] cell: cells){
                    int row = cell[0];
                    int col = cell[1];
                    if(oob(grid,row,col) || grid[row][col] == 0 || grid[row][col] == 2) continue;
                    grid[row][col] = 2;
                    queue.add(new int[]{row,col});
                    freshCount--;
                }
            }
        }

        return freshCount == 0 ? minutes-1: -1;


    }


    public static boolean oob(int[][] grid, int row, int col){

        return row < 0 || row >grid.length-1 || col <0 || col > grid[0].length-1;
    }
}
