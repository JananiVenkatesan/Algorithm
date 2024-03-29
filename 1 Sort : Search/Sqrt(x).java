/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int sqrt(int x) {
        if(x < 2)
            return x;
        int low = 0, high = x;
        while (high - low > 1) {  
             int mid = low + (high - low) / 2;  
             int div = x / mid;  
             if (mid == div) 
                return mid;  
             if (mid < div) 
                low = mid;  
             else 
                high = mid;  
        }  
       
       return low;
    }
}