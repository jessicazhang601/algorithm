/* Search a 2D Matrix 

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int start = 0; int end = m - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == matrix[mid][0]) {
                return true;
            }else if(target < matrix[mid][0]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        int row = 0;
        if(matrix[start][0] <= target && matrix[start][n-1] >= target) {
            row = start;
        }else if(matrix[end][0] <= target && matrix[end][n-1] >= target) {
            row = end;
        }else {
            return false;
        }
        
    
        start = 0;
        end = n - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == matrix[row][mid]){
                return true;
            }else if (target < matrix[row][mid]){
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        
        return false;
    }
    
}
