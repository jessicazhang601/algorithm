/* Climbing Stairs 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example
Given an example n=3 , 1+1+1=2+1=1+2=3
return 3
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        //1. 动态规划一定要注意： set up initial case
        if(n == 0) {
            return 1;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        //2. set up memory array
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}