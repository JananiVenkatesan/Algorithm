/*

There are N children standing in a line. Each child is assigned a 
rating value.

You are giving candies to these children subjected to the following 
requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        if(ratings.length == 1)
            return 1;
            
        int[] candy = new int[ratings.length];
        int sum = ratings.length;
        
        for(int i = 1, k = 1; i < candy.length; i ++){
            if(ratings[i] > ratings[i - 1]){
                candy[i] = k;
                k ++;
            }
            else{
                k = 1;
            }
        }
        
        for(int j = ratings.length - 2, k = 1; j >= 0; j --){
            if(ratings[j] > ratings[j + 1]){
                candy[j] = Math.max(candy[j], k);
                k ++;
            }
            else{
                k = 1;
            }
        }
        
        for(int i = 0; i < candy.length; i ++){
            sum += candy[i];
        }
        return sum;
    }
}