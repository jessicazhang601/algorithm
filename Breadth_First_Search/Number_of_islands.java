/*
Number of Islands 

Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.


*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    private class Coordinate{
        public int x;
        public int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int answer = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == true) {
                    markByBFS(i, j, grid);
                    answer++;
                }
            }
       
        }
        return answer;
    }
    
    private void markByBFS(int i, int j, boolean[][] grid) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        grid[i][j] = false;
        int[] xDirect = {0, 0, 1, -1};
        int[] yDirect = {1, -1, 0, 0};
        while(!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for(int count = 0; count < 4; count++){
                Coordinate adj = new Coordinate(curr.x + xDirect[count], curr.y + yDirect[count]);
                if(!inBound(adj, grid)) {
                    continue;
                }
                if(grid[adj.x][adj.y] == true){
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean inBound(Coordinate curr, boolean[][] grid) {
        if(curr.x < 0 || curr.x >= grid.length || curr.y < 0 || curr.y >= grid[0].length) {
            return false;
        }
        return true;
    }
    
}