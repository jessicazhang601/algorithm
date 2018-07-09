/* 832. Flipping an Image
DescriptionHintsSubmissionsDiscussSolution
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int p1 = 0;
            int p2 = n-1;
            while (p1 <= p2) {
                if (p1 < p2) {
                    helper(A, i, p1, i, p2);
                    helper2(A, i, p1);
                    helper2(A, i, p2);
                }else {
                    helper2(A, i, p1);
                }
                p1++;
                p2--;
            }  
        }
        return A;
    }
    
    private void helper(int[][] A, int x1, int y1, int x2, int y2) {
        int temp = A[x1][y1];
        
        A[x1][y1] = A[x2][y2];
        A[x2][y2] = temp;
    }
    
    private void helper2(int[][] A, int x, int y) {
        if (A[x][y] == 0){
            A[x][y] = 1;
        }else{
            A[x][y] =0;
        }
    }
}