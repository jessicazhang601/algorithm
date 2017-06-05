/* Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9
 */

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        int[] f = new int [n + 1];
        
        for(int i = 0; i < f.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i * i <= n; i++) {
            f[i * i] = 1;
        } 
        
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
    }
}
