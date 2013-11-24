

public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return n;
        }
        int p1 = 1, p2 = 2, p3 = 0;
        for(int i = 2; i < n; i ++){
            p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }
        
        return p3;
    }
}     

/*
Solution:
    Iterative
*/
public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n <= 0){
            return 0;
        }
        // If do not return here, when n = 1 or 2, ways is going to be overflow
        if(n == 1 || n == 2){
            return n;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for(int i = 2; i < n; i ++){
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        
        return ways[n - 1];
    }
}  


/*
Solution:
    Recursive
*/

public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n < 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}        
